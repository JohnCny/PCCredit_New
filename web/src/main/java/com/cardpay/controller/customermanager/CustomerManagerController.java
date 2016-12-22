package com.cardpay.controller.customermanager;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 客户经理管理controller
 *
 * @author yanweichen
 */
@Api(value = "/customerManager", description = "客户经理管理")
@RestController
@RequestMapping("/customerManager")
public class CustomerManagerController extends BaseController<TCustomerManager, Integer> {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerManagerService customerManagerService;

    /**
     * 创建客户经理
     *
     * @param user 用户信息
     * @param customerManager 客户经理信息
     * @return 视图和数据
     */
    @RequestMapping(value = "/addManager",method = RequestMethod.POST)
    private ModelAndView addManager(User user, TCustomerManager customerManager){
        userService.insert(user);
        customerManager.setUserId(user.getId());
        customerManagerService.insert(customerManager);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }

    /**
     * 更新客户经理
     *
     * @param user 用户信息
     * @param customerManager 客户经理信息
     * @return 视图和数据
     */
    @RequestMapping(value = "/updateManager",method = RequestMethod.POST)
    private ModelAndView updateManager(User user, TCustomerManager customerManager){
        userService.updateByPrimaryKey(user);
        customerManager.setUserId(user.getId());
        customerManagerService.updateByPrimaryKey(customerManager);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }
}
