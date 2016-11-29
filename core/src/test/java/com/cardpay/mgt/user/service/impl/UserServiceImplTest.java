package com.cardpay.mgt.user.service.impl;

import com.cardpay.mgt.user.dao.AuthorityMapper;
import com.cardpay.mgt.user.dao.AuthorityOperationMapper;
import com.cardpay.mgt.user.dao.AuthorityResourcesMapper;
import com.cardpay.mgt.user.dao.OperationMapper;
import com.cardpay.mgt.user.dao.ResourcesMapper;
import com.cardpay.mgt.user.dao.RoleAuthorityMapper;
import com.cardpay.mgt.user.dao.RoleMapper;
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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({UserServiceImpl.class})
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRoleMapper userRoleMapper;

    @Mock
    private RoleAuthorityMapper roleAuthorityMapper;

    @Mock
    private AuthorityOperationMapper authorityOperationMapper;

    @Mock
    private AuthorityResourcesMapper authorityResourcesMapper;

    @Mock
    private ResourcesMapper resourcesMapper;

    @Mock
    private OperationMapper operationMapper;

    @Mock
    private RoleMapper roleMapper;

    @Mock
    private AuthorityMapper authorityMapper;

    private User user;

    @Before
    public void setUp() {
        user = User.UserBuilder.get().withId(1).withPassword("123").withUsername("test").build();
    }

    @Test
    public void getUserAuthority() throws Exception {
        PowerMockito.whenNew(User.class).withAnyArguments().thenReturn(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(1);
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        PowerMockito.when(userRoleMapper.select(userRole)).thenReturn(userRoles);
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setRoleId(1);
        roleAuthority.setAuthorityId(1);
        List<RoleAuthority> roleAuthorities = new ArrayList<>();
        roleAuthorities.add(roleAuthority);
        PowerMockito.when(roleAuthorityMapper.selectByRoleList(userRoles)).thenReturn(roleAuthorities);
        AuthorityOperation authorityOperation = new AuthorityOperation();
        authorityOperation.setAuthorityId(1);
        authorityOperation.setOperationId(1);
        List<AuthorityOperation> authorityOperations = new ArrayList<>();
        authorityOperations.add(authorityOperation);
        PowerMockito.when(authorityOperationMapper.selectByAuthoritList(roleAuthorities)).thenReturn(authorityOperations);
        AuthorityResources authorityResources = new AuthorityResources();
        authorityResources.setAuthorityId(1);
        authorityResources.setResourceId(1);
        List<AuthorityResources> authorityResourcesList = new ArrayList<>();
        authorityResourcesList.add(authorityResources);
        PowerMockito.when(authorityResourcesMapper.selectByAuthoritList(roleAuthorities)).thenReturn(authorityResourcesList);
        Authority authority = new Authority();
        authority.setId(1);
        authority.setAuthorityName("super");
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authority);
        PowerMockito.when(authorityMapper.selectByList(roleAuthorities)).thenReturn(authorities);
        Operation operation = new Operation();
        operation.setId(1);
        operation.setOperationName("add");
        List<Operation> operations = new ArrayList<>();
        operations.add(operation);
        PowerMockito.when(operationMapper.selectByIdList(authorityOperations)).thenReturn(operations);
        Resources resources = new Resources();
        resources.setId(1);
        resources.setResoucreName("/test");
        List<Resources> resourcesList = new ArrayList<>();
        PowerMockito.when(resourcesMapper.selectByIdList(authorityResourcesList)).thenReturn(resourcesList);
        Set<String> userAuthority = userService.getUserAuthority(user);
        for (String str : userAuthority) {
            Assert.assertEquals(str, "super:/test:add");
        }
    }

    @Test
    public void getUserRole() throws Exception {
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(1);
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        PowerMockito.when(userRoleMapper.select(userRole)).thenReturn(userRoles);
        Role role = new Role();
        role.setId(1);
        role.setRoleName("super");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        PowerMockito.when(roleMapper.selectByUserRoleList(userRoles)).thenReturn(roles);
        Set<String> set = userService.getUserRole(user);
        for (String str : set) {
            Assert.assertEquals(str, "super");
        }
    }
}