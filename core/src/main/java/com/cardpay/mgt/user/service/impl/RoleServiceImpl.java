package com.cardpay.mgt.user.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.user.dao.AuthorityMapper;
import com.cardpay.mgt.user.dao.RoleAuthorityMapper;
import com.cardpay.mgt.user.dao.RoleMapper;
import com.cardpay.mgt.user.model.Authority;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.RoleAuthority;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.vo.AuthorityGroup;
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
    public List<AuthorityGroup> selectAuthorityGroup() {
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
        int roleId = roleMapper.insertSelective(role);
        if (roleId <= 0) {
            LogTemplate.info(this.getClass(), "roleId", roleId);
            return Boolean.FALSE;
        }
        Map<String, Object> map = new HashedMap();
        map.put("roleId", roleId);
        map.put("authorityIds", authorityIds);
        roleAuthorityMapper.insertArray(map);
        return Boolean.TRUE;
    }

    @Override
    public List<AuthorityGroup> selectRole(Integer roleId) {
        List<String> authorityGroups = authorityMapper.selectAuthorityGroup();
        List<Authority> authorities = authorityMapper.selectByRoleId(roleId);
        return getGroup(authorityGroups, authorities);
    }

    private List<AuthorityGroup> getGroup(List<String> authorityGroups, List<Authority> authorities) {
        List<AuthorityGroup> list = new ArrayList<>();
        for (String name : authorityGroups) {
            AuthorityGroup authorityGroup = new AuthorityGroup();
            authorityGroup.setGroupName(name);
            List<Authority> temp = new ArrayList<>();
            for (Authority authority : authorities) {
                if (name.equals(authority.getAuthorityDescription())) {
                    temp.add(authority);
                }
            }
            authorityGroup.setAuthorityList(temp);
            list.add(authorityGroup);
        }
        return list;
    }
}
