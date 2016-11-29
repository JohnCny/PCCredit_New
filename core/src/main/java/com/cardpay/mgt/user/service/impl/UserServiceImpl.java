package com.cardpay.mgt.user.service.impl;


import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.user.dao.AuthorityMapper;
import com.cardpay.mgt.user.dao.AuthorityOperationMapper;
import com.cardpay.mgt.user.dao.AuthorityResourcesMapper;
import com.cardpay.mgt.user.dao.OperationMapper;
import com.cardpay.mgt.user.dao.ResourcesMapper;
import com.cardpay.mgt.user.dao.RoleAuthorityMapper;
import com.cardpay.mgt.user.dao.RoleMapper;
import com.cardpay.mgt.user.dao.UserMapper;
import com.cardpay.mgt.user.dao.UserRoleMapper;
import com.cardpay.mgt.user.model.Authority;
import com.cardpay.mgt.user.model.AuthorityOperation;
import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.Operation;
import com.cardpay.mgt.user.model.Resources;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.RoleAuthority;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户Service层实现
 *
 * @author rankai
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Autowired
    private AuthorityOperationMapper authorityOperationMapper;

    @Autowired
    private AuthorityResourcesMapper authorityResourcesMapper;

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private OperationMapper operationMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public Set<String> getUserAuthority(User user) {

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        List<UserRole> userRoles = userRoleMapper.select(userRole);
        List<RoleAuthority> roleAuthorities = roleAuthorityMapper.selectByRoleList(userRoles);

        List<AuthorityOperation> authorityOperations = authorityOperationMapper.selectByAuthoritList(roleAuthorities);
        List<AuthorityResources> authorityResources = authorityResourcesMapper.selectByAuthoritList(roleAuthorities);

        List<Authority> authorities = authorityMapper.selectByList(roleAuthorities);
        List<Operation> operationes = operationMapper.selectByIdList(authorityOperations);
        List<Resources> resourceses = resourcesMapper.selectByIdList(authorityResources);

        Set<String> set = new HashSet<>();
        StringBuffer stringBuffer;
        for (Authority authority : authorities) {
            for (Resources resources : resourceses) {
                for (Operation operation : operationes) {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(authority.getAuthorityName()).append(":").append(resources.getResoucreName()).append(":").append(operation.getOperationName());
                    set.add(stringBuffer.toString());
                }
            }
        }
        return set;
    }

    @Override
    public Set<String> getUserRole(User user) {
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        List<UserRole> userRoles = userRoleMapper.select(userRole);
        List<Role> roles = roleMapper.selectByUserRoleList(userRoles);
        Set<String> set = new HashSet<>();
        for (Role role : roles) {
            set.add(role.getRoleName());
        }
        return set;
    }
}
