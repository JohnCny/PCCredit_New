package com.cardpay.mgt.user.service.impl;


import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.user.dao.UserMapper;
import com.cardpay.mgt.user.dao.UserRoleMapper;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * User的Service实现
 *
 * @author rankai
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Set<String> getUserAuthority(User user) {
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        List<UserRole> userRoles = userRoleMapper.select(userRole);
        return null;
    }
}
