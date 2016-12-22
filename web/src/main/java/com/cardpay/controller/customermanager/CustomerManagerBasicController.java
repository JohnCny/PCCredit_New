package com.cardpay.controller.customermanager;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.util.ReflectUtil;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerListVo;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    /**
     * 客户经理列表
     */
    @ResponseBody
    @RequestMapping(value = "/pageList",method = RequestMethod.GET)
    @ApiOperation(value = "客户经理列表页面", notes = "客户经理列表页面", httpMethod = "GET")
    public DataTablePage pageList(TCustomerManagerListVo customerManagerListVo){
        TCustomerManager customerManager = customerManagerService.selectByPrimaryKey(ShiroKit.getUserId());
        Map<String, Object> map = ReflectUtil.transBean2Map(customerManagerListVo);
        map.put("organizationId",customerManager.getOrganizationId());
        //查看当前机构下的客户经理
        return dataTablePage("selectListVo",map);
    }

    /**
     * 前往客户经理创建页面
     *
     * @return 页面
     */
    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    @ApiOperation(value = "前往客户经理创建页面", notes = "前往客户经理创建页面", httpMethod = "GET")
    public ModelAndView toAdd(){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    /**
     * 创建客户经理
     *
     * @param user 用户信息
     * @param customerManager 客户经理信息
     * @return 视图和数据
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "创建客户经理", notes = "创建客户经理", httpMethod = "POST")
    public ModelAndView add(@ApiParam("用户信息") @ModelAttribute User user,
                            @ApiParam("客户经理信息") @ModelAttribute TCustomerManager customerManager){
        userService.insert(user);
        customerManager.setUserId(user.getId());
        customerManagerService.insert(customerManager);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }

    /**
     * 前往客户经理创建页面
     *
     * @return 页面
     */
    @RequestMapping(value = "/toUpdate",method = RequestMethod.GET)
    @ApiOperation(value = "前往客户经理更新页面", notes = "前往客户经理更新页面", httpMethod = "GET")
    public ModelAndView toUpdate(){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    /**
     * 更新客户经理
     *
     * @param user 用户信息
     * @param customerManager 客户经理信息
     * @return 视图和数据
     */
    @RequestMapping(method = RequestMethod.PUT)
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
    @RequestMapping(method = RequestMethod.DELETE)
    public ResultTo delete(@ApiParam("用户信息") @RequestParam("userId") Integer userId){
        ResultTo resultTo = new ResultTo();
        User user = new User();
        user.setId(userId);
        user.setStatus(1);//TODO:改为枚举 1锁定
        Integer result = userService.updateSelectiveByPrimaryKey(user);
        resultTo.setIsSuccess(result);
        return resultTo;
    }
}
