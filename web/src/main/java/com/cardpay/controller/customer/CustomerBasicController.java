package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.IDcardUtil;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerIndustry;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.service.TCustomerIndustryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.cardpay.basic.common.constant.CustomerStatusEnum.*;


/**
 * 客户controller
 *
 * @author chenkai
 */
@Api(value = "/api/customerBasic", description = "客户基本信息")
@RestController
@RequestMapping("/api/customerBasic")
public class CustomerBasicController extends BaseController<TCustomerBasic> {
    /**
     * 客户信息
     */
    @Autowired
    private TCustomerBasicService customerBasicService;

    /**
     * 客户行业信息
     */
    @Autowired
    private TCustomerIndustryService tCustomerIndustryService;

    /**
     * 验证证件号码是否已经存在
     *
     * @param identityCard 证件号码
     * @return true/false
     */
    @GetMapping("/idCardExist")
    @SystemControllerLog("验证证件号码是否已经存在")
    @ApiOperation(value = "证件号码验重", notes = "证件号码验重", httpMethod = "GET")
    public ResultTo validate(@ApiParam(value = "证件号码", required = true) @RequestParam String identityCard) {
        if (!IDcardUtil.verify(String.valueOf(identityCard))) {
            return new ResultTo(ResultEnum.ID_CARD_ERROR);
        }
        //TODO :冉凯没提交机构
        boolean idCardExist = customerBasicService.isIdCardExist(identityCard, 1);
        return new ResultTo().setData(idCardExist);
    }

    /**
     * 客户行业关系
     *
     * @param customerId 客户id
     * @param industry 行业id
     * @return 关系列表
     */
    private List<TCustomerIndustry> customerIndustry(int customerId, String industry) {
        List<TCustomerIndustry> list = new ArrayList<>();
        String[] split = industry.split(",");
        for (String id : split) {
            int industryId = Integer.parseInt(id);
            TCustomerIndustry tCustomerIndustry = new TCustomerIndustry();
            tCustomerIndustry.setIndustryId(industryId);
            tCustomerIndustry.setCustomerId(customerId);
            list.add(tCustomerIndustry);
        }
        return list;
    }

    /**
     * 更新客户基本信息
     *
     * @param tCustomerBasic 客户基本信息
     * @return 数据库变更数量
     */
    @PutMapping
    @SystemControllerLog("更新客户基本信息")
    @ApiOperation(value = "更新客户基本信息", notes = "更新客户基本信息", httpMethod = "PUT")
    public ResultTo update(@ApiParam(value = "客户基本信息", required = true) @ModelAttribute TCustomerBasic tCustomerBasic
            , @RequestParam String industry) {
        Integer userId = ShiroKit.getUserId();
        tCustomerBasic.setModifyTime(new Date());
        tCustomerBasic.setModifyBy(userId);
        Integer count = customerBasicService.updateSelectiveByPrimaryKey(tCustomerBasic);
        if (count != null && count != 0) {
            List<TCustomerIndustry> list = customerIndustry(tCustomerBasic.getId(), industry);
            int batchUpdate = tCustomerIndustryService.batchUpdate(list);
            return batchUpdate != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
        }
        return new ResultTo(ResultEnum.SERVICE_ERROR);
    }


    /**
     * 新建客戶经理
     *
     * @param tCustomerBasic 客户基本信息
     * @param industry       行业id
     * @return 客户id
     */
    @PostMapping
    @SystemControllerLog("新建客戶经理")
    @ApiOperation(value = "新建客戶", notes = "新建客戶经理", httpMethod = "POST")
    public ResultTo newCustomer(@ApiParam(value = "客户基本信息", required = true) @ModelAttribute TCustomerBasic tCustomerBasic
            , @ApiParam(value = "行业id(,分割)", required = true) @RequestParam String industry) {
        Integer userId = ShiroKit.getUserId();
        Integer managerId = customerBasicService.getManagerId(userId);
        tCustomerBasic.setCustomerManagerId(managerId);
        tCustomerBasic.setCreateBy(userId);
        tCustomerBasic.setCreateTime(new Date());
        tCustomerBasic.setModifyBy(userId);
        tCustomerBasic.setModifyTime(new Date());
        tCustomerBasic.setCustomerStatus(ConstantEnum.CustomerStatus.STATUS0.getVal());
        Integer count = customerBasicService.insertSelective(tCustomerBasic);
        if (count != null && count != 0) {
            List<TCustomerIndustry> list = customerIndustry(tCustomerBasic.getId(), industry);
            int insert = tCustomerIndustryService.batchInsert(list);
            return insert != 0 ? new ResultTo().setData(tCustomerBasic.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR);
        }
        return new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 按条件查询客户信息
     *
     * @return 客户信息
     */
    @RequestMapping("/condition")
    @ApiOperation(value = "按条件查询客户信息", notes = "按条件查询客户信息", httpMethod = "GET")
    public DataTablePage queryCondition() {
        Map<String, Object> map = new HashMap<>();
        Integer managerId = customerBasicService.getManagerId(ShiroKit.getUserId());
        map.put("customerManagerId", managerId);
        return dataTablePage("queryCustomerByCondition", map);
    }

    /**
     * 查询证件类型/文化程度/婚姻状况信息
     *
     * @return 证件类型/文化程度/婚姻状况信息
     */
    @GetMapping("/allStatus")
    @ApiOperation(value = "证件类型/文化程度/婚姻状况信息", notes = "证件类型/文化程度/婚姻状况信息", httpMethod = "GET")
    public ResultTo allStatus() {
        List<SelectModel> cert = customerBasicService.getCert();
        List<SelectModel> educationDegree = customerBasicService.getEducationDegree();
        List<SelectModel> marriageStatus = customerBasicService.getMarriageStatus();
        return new ResultTo().setDataMap("cert", cert).setDataMap("educationDegree", educationDegree)
                .setDataMap("marriageStatus", marriageStatus);
    }

    /**
     * 查询证件类型
     *
     * @return 证件类型
     */
    @GetMapping("/cert")
    @ApiOperation(value = "查询证件类型", notes = "查询证件类型", httpMethod = "GET")
    public ResultTo cert() {
        List<SelectModel> cert = customerBasicService.getCert();
        return new ResultTo().setData(cert);
    }

    /**
     * 查询文化程度
     *
     * @return 查询文化程度
     */
    @GetMapping("/educationDegree")
    @ApiOperation(value = "查询文化程度", notes = "查询文化程度", httpMethod = "GET")
    public ResultTo educationDegree() {
        List<SelectModel> educationDegree = customerBasicService.getEducationDegree();
        return new ResultTo().setData(educationDegree);
    }

    /**
     * 查询婚姻状况
     *
     * @return 查询婚姻状况
     */
    @GetMapping("/marriageStatus")
    @ApiOperation(value = "查询婚姻状况", notes = "查询婚姻状况", httpMethod = "GET")
    public ResultTo marriageStatus() {
        List<SelectModel> marriageStatus = customerBasicService.getMarriageStatus();
        return new ResultTo().setData(marriageStatus);
    }

    /**
     * 批量禁用客户
     *
     * @param customerIds 客户id(,分割)
     * @return 数据变更记录
     */
    @DeleteMapping("/del/{id}")
    @SystemControllerLog("用户禁用")
    @ApiOperation(value = "批量禁用客户", notes = "批量禁用客户", httpMethod = "DELETE")
    public ResultTo deleteCustomer(@ApiParam("客户id(,分割)") @PathVariable("id") String customerIds) {
        List<Integer> ids = new ArrayList<>();
        String[] split = customerIds.split(",");
        for (String id : split) {
            int customerId = Integer.parseInt(id);
            ids.add(customerId);
        }
        Map<String, Object> map = new HashMap<>();
        Integer managerId = customerBasicService.getManagerId(ShiroKit.getUserId());
        map.put("status", FORBIDDEN.getValue());
        map.put("customerIds", ids);
        map.put("managerId", managerId);
        int count = customerBasicService.updateStatus(map);
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 按id查询客户信息
     *
     * @param customerId 客户id
     * @return 客户信息页面
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "按id查询客户信息", notes = "按id查询客户信息", httpMethod = "GET")
    public ResultTo index(@ApiParam(value = "客户id", required = true) @PathVariable("id") int customerId) {
        TCustomerBasic tCustomerBasic = customerBasicService.selectByPrimaryKey(customerId);
        return new ResultTo().setData(tCustomerBasic);
    }

    /**
     * 查询可删除的客户经理信息
     *
     * @return 可删除的客户经理信息
     */
    @RequestMapping("/del")
    @ApiOperation(value = "查询可删除的客户经理", notes = "查询可删除的客户经理", httpMethod = "GET")
    public DataTablePage selectDelete() {
        Map<String, Object> map = new HashMap();
        Integer managerId = customerBasicService.getManagerId(ShiroKit.getUserId());
        map.put("managerId", managerId);
        return dataTablePage("selectDelete", map);
    }

    /**
     * 按id删除客户信息
     *
     * @param customerId 客户id
     * @return 数据库变记录
     */
    @DeleteMapping("/{id}")
    @SystemControllerLog("删除客户经理信息")
    @ApiOperation(value = "删除客户经理信息", notes = "删除客户经理信息", httpMethod = "DELETE")
    public ResultTo delete(@ApiParam(value = "客户经理id", required = true) @PathVariable("id") int customerId) {
        Integer count = customerBasicService.deleteCustomer(customerId);
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

}
