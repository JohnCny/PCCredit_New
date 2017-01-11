package com.cardpay.controller.application.basic;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.application.balancecross.dao.TTemplateGroupMapper1;
import com.cardpay.mgt.application.balancecross.model.vo.BalanceCrossGroup;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.basic.model.vo.TApplicationVo;
import com.cardpay.mgt.application.basic.service.TApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cardpay.controller.application.enums.ApplicationStatus.*;

/**
 * 进件管理
 *
 * @author chenkai
 */

@RestController
@RequestMapping("/api/application")
public class ApplicationController extends BaseController<TApplication> {
    /**
     * 进件基本信息Service
     */
    @Autowired
    private TApplicationService tApplicationService;

    @Autowired
    private TTemplateGroupMapper1 templateGroupMapper;

    /**
     * 根据模板查询ipc财务报表
     *
     * @param applicationId 进件Id
     * @param templateId    模板Id
     * @return
     */
    @GetMapping("/ipc/{applicationId}/{templateId}")
    public ResultTo selectIPC(@PathVariable("applicationId") Integer applicationId, @PathVariable("templateId") Integer templateId) {
        ResultTo resultTo = new ResultTo();
        List<BalanceCrossGroup> balanceCrossGroups = templateGroupMapper.selectBalanceCross(applicationId, templateId);
        resultTo.setData(balanceCrossGroups);
        return resultTo;
    }

    /**
     * 查询此产品是否可进行进件申请
     *
     * @param productId 产品Id
     * @return true/false
     */
    @GetMapping("/ifProduct")
    public ResultTo queryProductIfOk(int productId) {
        boolean flag = tApplicationService.queryProductIfOk(ShiroKit.getUserId(), productId);
        return new ResultTo().setData(flag);
    }

    /**
     * 查询此客户是否申请过此产品
     *
     * @param customerId 客户Id
     * @param productId  产品Id
     * @return true/false
     */
    @GetMapping("/ifCustomer")
    public ResultTo queryCustomerIfHaveProduct(int productId, int customerId) {
        boolean flag = tApplicationService.queryCustomerIfHaveProduct(customerId, productId);
        return new ResultTo().setData(flag);
    }

    /**
     * 新建进件
     *
     * @param productId  产品id
     * @param customerId 客户id
     * @return 进件Id
     */
    @PostMapping
    public ResultTo insertApplication(int productId, int customerId) {
        Integer managerId = ShiroKit.getUserId();
        TApplication tApplication = new TApplication();
        tApplication.setCreateTime(new Date());
        tApplication.setProductId(productId);
        tApplication.setCustomerId(customerId);
        tApplication.setCustomerManagerId(managerId);
        tApplication.setApplicationStatus(APP_UNFINISHED.getValue());
        Integer integer = tApplicationService.insertSelective(tApplication);
        return integer != 0 ? new ResultTo().setData(tApplication.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 查询客户经理下的所有进件
     *
     * @return 进件列表
     */
    @RequestMapping("/pageList")
    public DataTablePage queryByManagerId(HttpServletRequest request) {
        Integer userId = ShiroKit.getUserId();
        Map<String, Object> map = new HashMap();
        if (ShiroKit.hasRole("manager")) {
            map.put("managerId", userId);
            return dataTablePage("queryByManagerId", map);
        }
        //团队负责人
        Integer teamId = (Integer) request.getAttribute("teamId");
        if (teamId != null && teamId != 0) {
            if (tApplicationService.userIfTeamBoss(userId, teamId)) {
                //按团队Id查询进件信息
                return dataTablePage("queryAppByTeamId", map);
            }
        }
        //团队负责人
        Integer orgId = (Integer) request.getAttribute("orgId");
        if (orgId != null && orgId != 0) {
            if (tApplicationService.userIfOrgBoss(userId, teamId)) {
                //按机构id查询进件信息
                return dataTablePage("queryAppByOrgId", map);
            }
        }
        return null;
    }

    /**
     * 按进件id查询进件信息
     *
     * @param applicationId 进件id
     * @return 进件列表
     */
    @GetMapping("/{id}")
    public ResultTo queryByApplication(@PathVariable("id") int applicationId) {
        TApplicationVo tApplicationVo = tApplicationService.queryByApplication(applicationId);
        return new ResultTo().setData(tApplicationVo);
    }


}
