package com.cardpay.controller.customermanager;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.util.DozerUtil;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerBaseVo;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerEditVo;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.customermanager.level.service.CustomerManagerLevelService;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
@RequestMapping("/customerManager")
public class CustomerManagerBasicController extends BaseController<TCustomerManager> {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerManagerService customerManagerService;

    @Autowired
    private CustomerManagerLevelService customerManagerLevelService;

    /**
     * 前往客户经理列表
     *
     * @return 客户经理列表页面
     */
    @GetMapping("/index")
    @ApiOperation(value = "前往客户经理列表", notes = "前往客户经理列表", httpMethod = "GET")
    public ModelAndView toList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customerManagerLevel",customerManagerLevelService.getCustomerManagerLevel());
        modelAndView.setViewName("/customerManager/index");
        return modelAndView;
    }

    /**
     * 客户经理列表
     */
    @ResponseBody
    @GetMapping(value = "/pageList")
    @ApiOperation(value = "获取客户经理列表", notes = "获取客户经理列表", httpMethod = "GET")
    public DataTablePage pageList(){
        TCustomerManager customerManager = customerManagerService.selectByUserId(ShiroKit.getUserId());
        Map<String, Object> map = new HashMap();
        //查看当前机构下的客户经理
        map.put("organizationId",customerManager.getOrganizationId());
        map.put("status",0);//TODO:等冉凯写枚举
        return dataTablePage("selectBaseVoList",map);
    }

    /**
     * 前往客户经理创建页面
     *
     * @return 页面
     */
    @GetMapping(value = "/toAdd")
    @ApiOperation(value = "前往客户经理创建页面", notes = "前往客户经理创建页面", httpMethod = "GET")
    public ModelAndView toAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customerManager/new");
        modelAndView.addObject("customerManagerLevel",customerManagerLevelService.getCustomerManagerLevel());
        return modelAndView;
    }

    /**
     * 创建客户经理
     *
     * @param user 用户信息
     * @param customerManager 客户经理信息
     * @return 视图和数据
     */
    @PostMapping()
    @ApiOperation(value = "创建客户经理", notes = "创建客户经理", httpMethod = "POST")
    public ModelAndView add(@ApiParam("用户信息") @ModelAttribute User user,
                            @ApiParam("客户经理信息") @ModelAttribute TCustomerManager customerManager){
        userService.insert(user);
        customerManager.setUserId(user.getId());
        customerManagerService.insert(customerManager);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customerManager/index");
        return modelAndView;
    }

    /**
     * 前往客户经理更新页面
     *
     * @return 页面
     */
    @GetMapping(value = "/{userId}")
    @ApiOperation(value = "前往客户经理更新页面", notes = "前往客户经理更新页面", httpMethod = "GET")
    public ModelAndView toUpdate(@PathVariable("userId") Integer userId){
        ModelAndView modelAndView = new ModelAndView();
        TCustomerManagerBaseVo customerManager = customerManagerService.selectBaseVoByUserId(userId);
        TCustomerManagerEditVo customerManagerEditVo = DozerUtil.map(customerManager, TCustomerManagerEditVo.class);
        customerManagerEditVo.setIfPause(0);
        customerManagerEditVo.setSystemLevel("系统建议你是傻吊");
        modelAndView.setViewName("/customerManager/edit");
        modelAndView.addObject("customerManager",customerManagerEditVo);
        modelAndView.addObject("customerManagerLevel",customerManagerLevelService.getCustomerManagerLevel());
        return modelAndView;
    }

    /**
     * 更新客户经理
     *
     * @param user 用户信息
     * @param customerManager 客户经理信息
     * @return 视图和数据
     */
    @PutMapping()
    @ApiOperation(value = "更新客户经理", notes = "更新客户经理", httpMethod = "PUT")
    public ModelAndView update(@ApiParam("用户信息") @ModelAttribute User user,
                               @ApiParam("客户经理信息") @ModelAttribute TCustomerManager customerManager){
        userService.updateByPrimaryKey(user);
        customerManager.setUserId(user.getId());
        customerManagerService.updateByPrimaryKey(customerManager);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }

    /**
     * 删除客户经理(封号)
     *
     * @param userId 用户id
     * @return 删除结果
     */
    @ResponseBody
    @DeleteMapping(value = "/{userId}")
    public ResultTo delete(@ApiParam("用户信息") @PathVariable("userId") Integer userId){
        ResultTo resultTo = new ResultTo();
        User user = new User();
        user.setId(userId);
        user.setStatus(1);//TODO:改为枚举 1锁定
        Integer result = userService.updateSelectiveByPrimaryKey(user);
        resultTo.setIsSuccess(result);
        return resultTo;
    }
}
