package com.cardpay.controller.customermanager;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.ErrorMessageUtil;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.customermanager.level.service.CustomerManagerLevelService;
import com.cardpay.mgt.user.enums.UserStatus;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户经理管理controller
 *
 * @author yanweichen
 */
@Api(value = "/customerManager", description = "客户经理管理")
@RestController
@RequestMapping("/customerManager")
public class CustomerManagerBasicController extends BaseController<TCustomerManager> {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerManagerService customerManagerService;

    @Autowired
    private CustomerManagerLevelService customerManagerLevelService;

    /**
     * 客户经理列表
     * levelId = -1 查询所有级别
     */
    @GetMapping(value = "/pageList")
    @ApiOperation(value = "获取客户经理列表", notes = "获取客户经理列表 levelId = -1 查询所有级别", httpMethod = "GET")
    public DataTablePage pageList() {
        TCustomerManager customerManager = customerManagerService.selectByUserId(ShiroKit.getUserId());
        Map<String, Object> map = new HashMap();
        //查看当前机构下的客户经理
        map.put("organizationId", customerManager.getOrganizationId());
        map.put("status", UserStatus.NORMAL.getStatus());
        return dataTablePage("selectBaseVoList", map);
    }

    /**
     * 创建客户经理
     *
     * @param customerManager 客户经理信息
     * @return 视图和数据
     */
    @PostMapping()
    @ApiOperation(value = "创建客户经理", notes = "创建客户经理", httpMethod = "POST")
    public ResultTo add(@ApiParam("客户经理信息") @ModelAttribute TCustomerManager customerManager,BindingResult result) {
        customerManagerService.insert(customerManager);
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        return new ResultTo();
    }

    /**
     * 前往客户经理更新页面
     *
     * @return 页面
     */
    @GetMapping(value = "/{userId}")
    @ApiOperation(value = "前往客户经理更新页面", notes = "前往客户经理更新页面", httpMethod = "GET")
    public ResultTo toUpdate(@PathVariable("userId") Integer userId) {
        ResultTo resultTo = new ResultTo();
        resultTo.setDataMap("customerManager", customerManagerService.assembleEditPageData(userId));
        resultTo.setDataMap("customerManagerLevel", customerManagerLevelService.getCustomerManagerLevel());
        return resultTo;
    }

    /**
     * 更新客户经理
     *
     * @param user            用户信息
     * @param customerManager 客户经理信息
     * @return 视图和数据
     */
    @PutMapping()
    @ApiOperation(value = "更新客户经理", notes = "更新客户经理", httpMethod = "PUT")
    public ResultTo update(@ApiParam("用户信息") @ModelAttribute User user,
                           @ApiParam("客户经理信息") @ModelAttribute TCustomerManager customerManager) {
        ResultTo resultTo = new ResultTo();
        user.setId(customerManager.getUserId());
        Integer result = customerManagerService.updateCustomerManager(user, customerManager, ShiroKit.getUser());
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 删除客户经理(封号)
     *
     * @param userId 用户id
     * @return 删除结果
     */
    @DeleteMapping(value = "/{userId}")
    @ApiOperation(value = "删除客户经理(封号)", notes = "删除客户经理(封号)", httpMethod = "DELETE")
    public ResultTo delete(@ApiParam("用户信息") @PathVariable("userId") Integer userId) {
        ResultTo resultTo = new ResultTo();
        User user = new User();
        user.setId(userId);
        user.setStatus(UserStatus.LOCK.getStatus());
        Integer result = userService.updateSelectiveByPrimaryKey(user);
        resultTo.setIsSuccess(result);
        return resultTo;
    }
}
