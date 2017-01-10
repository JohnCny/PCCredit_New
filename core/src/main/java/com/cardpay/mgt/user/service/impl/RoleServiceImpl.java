package com.cardpay.mgt.user.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.DozerUtil;
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
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色Service层实现
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Override
    public List<AuthorityGroupVo> selectAuthorityGroup() {
        List<String> authorityGroups = authorityMapper.selectAuthorityGroup();
        List<Authority> authorities = authorityMapper.selectAllByStatus();
        return getGroup(authorityGroups, authorities);
    }

    @Override
    public List<Authority> selectOperationList(String groupName) {
        Authority authority = new Authority();
        authority.setAuthorityDescription(groupName);
        authority.setAuthorityStatus(1);
        return authorityMapper.select(authority);
    }

    @Override
    @Transactional
    public boolean update(Integer roleId, Integer oldAuthorityId, Integer newAuthorityId) {
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setRoleId(roleId);
        roleAuthority.setAuthorityId(oldAuthorityId);
        int count = -1;
        if (oldAuthorityId == newAuthorityId) {
            return Boolean.TRUE;
        }
        if (oldAuthorityId > 0) {
            if (newAuthorityId > 0) {
                //更新操作
                LogTemplate.debug(this.getClass(), "message", "角色权限更新操作");
                RoleAuthority oldRoleAuthority = roleAuthorityMapper.selectOne(roleAuthority);
                if (oldRoleAuthority != null) {
                    count++;
                    oldRoleAuthority.setAuthorityId(newAuthorityId);
                }
            } else {
                //删除操作
                LogTemplate.debug(this.getClass(), "message", "角色权限删除操作");
                count = roleAuthorityMapper.delete(roleAuthority);
            }
        } else {
            if (newAuthorityId > 0) {
                //增加操作
                LogTemplate.debug(this.getClass(), "message", "角色权限增加操作");
                roleAuthority.setAuthorityId(newAuthorityId);
                count = roleAuthorityMapper.insertSelective(roleAuthority);
            }
        }
        LogTemplate.debug(this.getClass(), "count", count);
        return count == -1 ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public boolean insertRole(Role role, Integer[] authorityIds) {
        User user = (User) ShiroKit.getPrincipal();
        role.setCreateBy(user.getId());
        role.setCreateTime(new Date());
        role.setRoleStatus(1);
        int count = roleMapper.insertSelective(role);
        if (count <= 0) {
            LogTemplate.info(this.getClass(), "count", count);
            return Boolean.FALSE;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < authorityIds.length; i++) {
            if (authorityIds[i] != -1) {
                list.add(authorityIds[i]);
            }
        }
        if (list.size() > 0) {
            Map<String, Object> map = new HashedMap();
            map.put("roleId", role.getId());
            map.put("authorityIds", list);
            roleAuthorityMapper.insertArray(map);
        }
        return Boolean.TRUE;
    }

    @Override
    public List<AuthorityGroupVo> selectRole(Integer roleId) {
        List<String> authorityGroups = authorityMapper.selectAuthorityGroup();
        List<Authority> authorities = authorityMapper.selectByRoleId(roleId);
        return getGroup(authorityGroups, authorities);
    }

    @Override
    public List<AuthorityGroupVo> selectAuthority(Integer roleId) {
        List<String> authorityGroups = authorityMapper.selectAuthorityGroup();
        List<Authority> authorities = authorityMapper.selectAllByStatus();
        List<AuthorityGroupVo> authorityGroupVos = getGroup(authorityGroups, authorities);
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setRoleId(roleId);
        List<RoleAuthority> roleAuthorities = roleAuthorityMapper.select(roleAuthority);
        for (AuthorityGroupVo authorityGroupVo : authorityGroupVos) {
            List<AuthorityVo> authorityList = authorityGroupVo.getAuthorityList();
            for (AuthorityVo authorityVo : authorityList) {
                for (RoleAuthority _roleAuthority : roleAuthorities) {
                    if (_roleAuthority.getAuthorityId() == authorityVo.getId()) {
                        authorityVo.setSelected(true);
                        break;
                    }
                }
            }
        }
        return authorityGroupVos;
    }

    @Override
    public boolean updateAuthorityIds(Role role, String[] authorityIds) {
        if (roleMapper.updateByPrimaryKeySelective(role) <= 0) {
            return Boolean.FALSE;
        }
        for (String str : authorityIds) {
            String[] split = str.split(",");
            update(role.getId(), Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        return true;
    }

    private List<AuthorityGroupVo> getGroup(List<String> authorityGroups, List<Authority> authorities) {
        List<AuthorityGroupVo> list = new ArrayList<>();
        for (String name : authorityGroups) {
            AuthorityGroupVo authorityGroup = new AuthorityGroupVo();
            authorityGroup.setGroupName(name);
            List<AuthorityVo> temp = new ArrayList<>();
            for (Authority authority : authorities) {
                if (name.equals(authority.getAuthorityDescription())) {
                    temp.add(DozerUtil.map(authority, AuthorityVo.class));
                }
            }
            authorityGroup.setAuthorityList(temp);
            list.add(authorityGroup);
        }
        return list;
    }
}
