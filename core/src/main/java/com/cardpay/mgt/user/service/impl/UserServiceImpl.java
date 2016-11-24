package com.cardpay.mgt.user.service.impl;


import com.cardpay.basic.base.service.BaseService;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.user.dao.AuthorityOperationMapper;
import com.cardpay.mgt.user.dao.AuthorityResourcesMapper;
import com.cardpay.mgt.user.dao.OperationMapper;
import com.cardpay.mgt.user.dao.ResourcesMapper;
import com.cardpay.mgt.user.dao.RoleAuthorityMapper;
import com.cardpay.mgt.user.dao.UserMapper;
import com.cardpay.mgt.user.dao.UserRoleMapper;
import com.cardpay.mgt.user.model.AuthorityOperation;
import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.Operation;
import com.cardpay.mgt.user.model.Resources;
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
 * User的Service实现
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

    @Override
    public Set<String> getUserAuthority(User user) {

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        List<UserRole> userRoles = userRoleMapper.select(userRole);
        List<RoleAuthority> roleAuthorities = roleAuthorityMapper.selectByRoleList(userRoles);

        List<AuthorityOperation> authorityOperations = authorityOperationMapper.selectByAuthoritList(roleAuthorities);
        List<AuthorityResources> authorityResourceses = authorityResourcesMapper.selectByAuthoritList(roleAuthorities);

        List<Operation> operationes = operationMapper.selectByIdList(authorityResourceses);
        List<Resources> resourceses = resourcesMapper.selectByIdList(authorityOperations);

        Set<String> set = new HashSet<>();
        for (Operation operation : operationes) {
            for (Resources resources : resourceses) {

            }
        }

        return null;
    }
}
