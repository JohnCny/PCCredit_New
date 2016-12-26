package com.cardpay.mgt.customermanager.basic.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.util.ReflectUtil;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customermanager.basic.dao.TCustomerManagerMapper;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerBaseVo;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerEditVo;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.customermanager.level.service.CustomerManagerLevelService;
import com.cardpay.mgt.menu.enums.RoleEnum;
import com.cardpay.mgt.modeifyhistory.util.CompareBeanUtil;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.service.UserRoleService;
import com.cardpay.mgt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 客户经理管理实现类
 *
 * @author yanweichen
 */
@Service
public class CustomerManagerServiceImpl extends BaseServiceImpl<TCustomerManager> implements CustomerManagerService {

    @Autowired
    private TCustomerManagerMapper customerManagerMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public List<TCustomerManagerEditVo> selectBaseVoList(Map<String, Object> map) {
        List<TCustomerManagerBaseVo> customerManagerBaseVos = customerManagerMapper.selectBaseVoList(map);
        List<TCustomerManagerEditVo> customerManagerEditVos = new ArrayList<>();
        for (TCustomerManagerBaseVo customerManagerBaseVo : customerManagerBaseVos) {
            customerManagerEditVos.add(conventEditVo(customerManagerBaseVo));
        }
        return customerManagerEditVos;
    }

    @Override
    public TCustomerManager selectByUserId(Integer userId) {
        TCustomerManager condition = new TCustomerManager();
        condition.setUserId(userId);
        return customerManagerMapper.selectOne(condition);
    }

    @Override
    public TCustomerManagerBaseVo selectBaseVoByUserId(Integer userId) {
        return customerManagerMapper.selectBaseVoByUserId(userId);
    }

    @Override
    public TCustomerManagerEditVo assembleEditPageData(Integer userId) {
        TCustomerManagerBaseVo customerManager = selectBaseVoByUserId(userId);
        TCustomerManagerEditVo customerManagerEditVo = conventEditVo(customerManager);
        //TODO:待需求确定系统建议规则
        customerManagerEditVo.setSystemLevel("系统建议你是傻吊");
        return customerManagerEditVo;
    }

    @Override
    @Transactional
    public Boolean addCustomerManager(User user, TCustomerManager customerManager) {
        Integer userResult = userService.insert(user);
        customerManager.setUserId(user.getId());
        Integer managerResult = insert(customerManager);
        UserRole userRole = new UserRole();
        userRole.setRoleId(RoleEnum.MANAGER.getRoleId());
        userRole.setUserId(user.getId());
        Integer userRoleResult = userRoleService.insert(userRole);
        Integer finalResult = userRoleResult+managerResult+userResult;
        return finalResult==3?true:false;
    }

    @Override
    @Transactional
    public Integer updateCustomerManager(User user, TCustomerManager customerManager,User modifyUser) {
        int userResult = 0;
        if(!ReflectUtil.checkBeanAllFiledIsNull(user,"id")){
            userResult = userService.updateSelectiveByPrimaryKey(user);
            CompareBeanUtil.compareBean(user, userService, "User", "用户模块", modifyUser);
        }
        int customerManagerResult = 0;
        if(!ReflectUtil.checkBeanAllFiledIsNull(customerManager,"userId")){
            customerManagerResult = updateSelectiveByPrimaryKey(customerManager);
            CompareBeanUtil.compareBean(customerManager, this, "CustomerManager"
                    , "客户经理模块", modifyUser);
        }
        int finalResult = customerManagerResult+userResult;
        return finalResult==2?1:1;
    }

    /**
     * 转换BaseVo为EditVo
     *
     * @param customerManagerBaseVo 客户经理基本信息
     * @return EditVo
     */
    private TCustomerManagerEditVo conventEditVo(TCustomerManagerBaseVo customerManagerBaseVo){
        TCustomerManagerEditVo customerManagerEditVo = new TCustomerManagerEditVo();
        customerManagerEditVo.setUserId(customerManagerBaseVo.getUser().getId());
        customerManagerEditVo.setLevelName(customerManagerBaseVo.getLevelName());
        customerManagerEditVo.setUserCname(customerManagerBaseVo.getUser().getUserCname());
        customerManagerEditVo.setEmployeeNumber(customerManagerBaseVo.getUser().getEmployeeNumber());
        customerManagerEditVo.setManagerStatus(customerManagerBaseVo.getManagerStatus());
        return customerManagerEditVo;
    }
}
