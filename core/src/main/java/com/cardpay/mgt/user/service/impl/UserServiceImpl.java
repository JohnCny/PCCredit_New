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
        //获取当前用户都有哪些角色
        List<UserRole> userRoles = userRoleMapper.select(userRole);
        //获取当前用户所拥有的角色对应的权限id集合
        List<RoleAuthority> roleAuthorities = roleAuthorityMapper.selectByRoleList(userRoles);

        //获取当前用户对应角色对应权限对应的操作
        List<AuthorityOperation> authorityOperations = authorityOperationMapper.selectByAuthoritList(roleAuthorities);
        //获取当前用户对应角色对应权限对应的资源
        List<AuthorityResources> authorityResources = authorityResourcesMapper.selectByAuthoritList(roleAuthorities);

        //根据当前用户获得所对应的所有权限
        List<Authority> authorities = authorityMapper.selectByList(roleAuthorities);
        //根据当前用户获得所对应的所有操作
        List<Operation> operationes = operationMapper.selectByIdList(authorityOperations);
        //根据当前用户获得所对应的所有资源
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
