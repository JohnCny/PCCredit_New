package com.cardpay.mgt.user.service.impl;

import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.user.dao.AuthorityMapper;
import com.cardpay.mgt.user.dao.RoleAuthorityMapper;
import com.cardpay.mgt.user.dao.RoleMapper;
import com.cardpay.mgt.user.model.Authority;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.RoleAuthority;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.vo.AuthorityGroupVo;
import com.cardpay.mgt.user.model.vo.AuthorityVo;
import com.cardpay.mgt.user.service.RoleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest({RoleServiceImpl.class, ShiroKit.class})
public class RoleServiceImplTest {

    @InjectMocks
    private RoleServiceImpl roleService;

    @Mock
    private RoleMapper roleMapper;

    @Mock
    private AuthorityMapper authorityMapper;

    @Mock
    private RoleAuthorityMapper roleAuthorityMapper;

    private Role role;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        role = Role.RoleBuilder.get().withRoleName("test").withCreateTime(new Date()).withRoleNameZh("测试").build();
    }

    @Test
    public void selectAuthorityGroup() throws Exception {
        List<String> authorityGroups = new ArrayList<>();
        authorityGroups.add("test");
        List<Authority> authorities = new ArrayList<>();
        Authority authority = new Authority();
        authority.setAuthorityDescription("test");
        authorities.add(authority);
        List<AuthorityGroupVo> authorityGroupVoList = new ArrayList<>();
        List<AuthorityVo> authorityVoList = new ArrayList<>();
        AuthorityVo authorityVo = new AuthorityVo();
        authorityVo.setAuthorityNameZh("测试123");
        authorityVoList.add(authorityVo);
        AuthorityGroupVo authorityGroupVo = new AuthorityGroupVo();
        authorityGroupVo.setGroupName("测试321");
        authorityGroupVo.setAuthorityList(authorityVoList);
        authorityGroupVoList.add(authorityGroupVo);
        PowerMockito.when(authorityMapper.selectAuthorityGroup()).thenReturn(authorityGroups);
        PowerMockito.when(authorityMapper.selectAllByStatus()).thenReturn(authorities);
        RoleServiceImpl spy = PowerMockito.spy(new RoleServiceImpl());
        PowerMockito.doReturn(authorityGroupVoList).when(spy, "getGroup", authorityGroups, authorities);
        List<AuthorityGroupVo> list = roleService.selectAuthorityGroup();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void selectOperationList() throws Exception {
        List<Authority> list = new ArrayList<>();
        Authority authority = new Authority();
        authority.setId(1);
        list.add(authority);
        Authority mock = PowerMockito.mock(Authority.class);
        PowerMockito.whenNew(Authority.class).withAnyArguments().thenReturn(mock);
        PowerMockito.when(authorityMapper.select(mock)).thenReturn(list);
        List<Authority> authorities = roleService.selectOperationList("测试");
        Integer n = 1;
        Assert.assertEquals(authorities.get(0).getId(), n);
    }

    @Test
    public void update() throws Exception {
        RoleAuthority mock = PowerMockito.mock(RoleAuthority.class);
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setRoleId(1);
        roleAuthority.setAuthorityId(2);
        PowerMockito.whenNew(RoleAuthority.class).withAnyArguments().thenReturn(mock);

        PowerMockito.when(roleAuthorityMapper.selectOne(mock)).thenReturn(roleAuthority);
        boolean flag;
        flag = roleService.update(1, 1, 2);
        Assert.assertTrue(flag);

        PowerMockito.when(roleAuthorityMapper.delete(mock)).thenReturn(1);
        flag = roleService.update(1, 1, -1);
        Assert.assertTrue(flag);

        PowerMockito.when(roleAuthorityMapper.insertSelective(mock)).thenReturn(1);
        flag = roleService.update(1, -1, 1);
        Assert.assertTrue(flag);
    }

    @Test
    public void insertRole() throws Exception {
        User user = User.UserBuilder.get().withId(1).build();
        PowerMockito.mockStatic(ShiroKit.class);
        PowerMockito.when(ShiroKit.getPrincipal()).thenReturn(user);
        Role role = new Role();
        Integer[] array = new Integer[]{1, 2, 3};

        PowerMockito.when(roleMapper.insertSelective(role)).thenReturn(1);
        boolean flag;
        flag = roleService.insertRole(role, array);
        Assert.assertTrue(flag);

        PowerMockito.when(roleMapper.insertSelective(role)).thenReturn(0);
        flag = roleService.insertRole(role, array);
        Assert.assertFalse(flag);
    }

    @Test
    public void selectRole() throws Exception {
        List<String> authorityGroups = new ArrayList<>();
        authorityGroups.add("test");
        List<Authority> authorities = new ArrayList<>();
        Authority authority = new Authority();
        authority.setAuthorityDescription("test");
        authorities.add(authority);
        List<AuthorityGroupVo> authorityGroupVoList = new ArrayList<>();
        List<AuthorityVo> authorityVoList = new ArrayList<>();
        AuthorityVo authorityVo = new AuthorityVo();
        authorityVo.setAuthorityNameZh("测试123");
        authorityVoList.add(authorityVo);
        AuthorityGroupVo authorityGroupVo = new AuthorityGroupVo();
        authorityGroupVo.setGroupName("测试321");
        authorityGroupVo.setAuthorityList(authorityVoList);
        authorityGroupVoList.add(authorityGroupVo);
        PowerMockito.when(authorityMapper.selectAuthorityGroup()).thenReturn(authorityGroups);
        PowerMockito.when(authorityMapper.selectByRoleId(1)).thenReturn(authorities);
        RoleServiceImpl spy = PowerMockito.spy(new RoleServiceImpl());
        PowerMockito.doReturn(authorityGroupVoList).when(spy, "getGroup", authorityGroups, authorities);
        List<AuthorityGroupVo> authorityGroupVos = roleService.selectRole(1);
        Assert.assertTrue(authorityGroupVos.size() > 0);
    }

    @Test
    public void selectAuthority() throws Exception {
        List<String> authorityGroups = new ArrayList<>();
        authorityGroups.add("test");
        List<Authority> authorities = new ArrayList<>();
        Authority authority = new Authority();
        authority.setAuthorityDescription("test");
        authorities.add(authority);
        List<AuthorityGroupVo> authorityGroupVoList = new ArrayList<>();
        List<AuthorityVo> authorityVoList = new ArrayList<>();
        AuthorityVo authorityVo = new AuthorityVo();
        authorityVo.setAuthorityNameZh("测试123");
        authorityVoList.add(authorityVo);
        AuthorityGroupVo authorityGroupVo = new AuthorityGroupVo();
        authorityGroupVo.setGroupName("测试321");
        authorityGroupVo.setAuthorityList(authorityVoList);
        authorityGroupVoList.add(authorityGroupVo);
        PowerMockito.when(authorityMapper.selectAuthorityGroup()).thenReturn(authorityGroups);
        PowerMockito.when(authorityMapper.selectByRoleId(1)).thenReturn(authorities);
        RoleServiceImpl spy = PowerMockito.spy(new RoleServiceImpl());
        PowerMockito.doReturn(authorityGroupVoList).when(spy, "getGroup", authorityGroups, authorities);
        RoleAuthority mock = PowerMockito.mock(RoleAuthority.class);
        PowerMockito.whenNew(RoleAuthority.class).withAnyArguments().thenReturn(mock);
        List<AuthorityGroupVo> authorityGroupVos = roleService.selectRole(1);
        Assert.assertTrue(authorityGroupVos.size() > 0);
    }

    @Test
    public void updateAuthorityIds() throws Exception {
        String[] str = new String[]{"1,2", "3,-1"};
        PowerMockito.when(roleMapper.updateByPrimaryKeySelective(role)).thenReturn(0);
        boolean flag;
        flag = roleService.updateAuthorityIds(role, str);
        Assert.assertFalse(flag);

        PowerMockito.when(roleMapper.updateByPrimaryKeySelective(role)).thenReturn(1);
        flag = roleService.updateAuthorityIds(role, str);
        Assert.assertTrue(flag);
    }

}