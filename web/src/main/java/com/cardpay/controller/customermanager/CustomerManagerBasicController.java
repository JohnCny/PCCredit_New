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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户经理管理controller
 *
 * @author yanweichen
 */
@Api(value = "/api/customerManager", description = "客户经理管理")
@RestController
@RequestMapping("/api/customerManager")
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
    @RequestMapping("/pageList")
    @ApiOperation(value = "获取客户经理列表", notes = "获取客户经理列表 levelId = -1 查询所有级别", httpMethod = "GET")
    public DataTablePage pageList() {
        Map<String, Object> map = new HashMap();
        //查看当前机构下的客户经理
        map.put("organizationId", ShiroKit.getOrgId());
        map.put("status", UserStatus.NORMAL.getStatus());
        return dataTablePage("selectBaseVoList", map);
    }

    /**
     * 获得客户经理信息
     *
     * @return 页面
     */
    @GetMapping("/{userId}")
    @ApiOperation(value = "获得客户经理信息", notes = "获得客户经理信息", httpMethod = "GET")
    public ResultTo get(@PathVariable("userId") Integer userId) {
        ResultTo resultTo = new ResultTo();
        resultTo.setDataMap("customerManager", customerManagerService.assembleEditPageData(userId));
        resultTo.setDataMap("customerManagerLevel", customerManagerLevelService.getCustomerManagerLevel());
        return resultTo;
    }

    /**
     * 更新客户经理
     *
     * @param customerManager 客户经理信息
     * @return 视图和数据
     */
    @PutMapping()
    @ApiOperation(value = "更新客户经理", notes = "更新客户经理", httpMethod = "PUT")
    public ResultTo update(@ApiParam("客户经理信息") @ModelAttribute TCustomerManager customerManager,BindingResult result) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        ResultTo resultTo = new ResultTo();
        Integer updateResult = customerManagerService.updateCustomerManager(customerManager);
        resultTo.setIsSuccess(updateResult);
        return resultTo;
    }

    /**
     * 删除客户经理(封号)
     *
     * @param userId 用户id
     * @return 删除结果
     */
    @DeleteMapping("/{userId}")
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
