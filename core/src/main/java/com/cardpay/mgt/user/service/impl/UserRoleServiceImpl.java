package com.cardpay.mgt.user.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.user.dao.UserRoleMapper;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色关系Service层接实现
 *
 * @author rankai
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public boolean updateUserRole(UserRole userRole) {
        UserRole newUserRole = userRoleMapper.selectOne(userRole);
        if (newUserRole == null) {
            int count = userRoleMapper.insertSelective(userRole);
            return count >= 0 ? Boolean.TRUE : Boolean.FALSE;
        } else {
            int count = userRoleMapper.delete(userRole);
            return count >= 0 ? Boolean.TRUE : Boolean.FALSE;
        }
    }
}
