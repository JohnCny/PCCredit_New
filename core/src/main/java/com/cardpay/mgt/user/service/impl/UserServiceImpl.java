package com.cardpay.mgt.user.service.impl;


import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.shrio.common.PasswordUtil;
import com.cardpay.core.shrio.common.ShiroKit;
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
import com.cardpay.mgt.user.model.UserAuthority;
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
    private RoleMapper roleMapper;

    @Override
    public Set<String> getUserAuthority(User user) {
        Set<String> set = new HashSet<>();
        List<UserAuthority> list = userMapper.selectByAuthority(user);
        StringBuffer stringBuffer;
        for (UserAuthority userAuthority : list) {
            stringBuffer = new StringBuffer();
            stringBuffer.append(userAuthority.getAuthorityName()).append(":").append(userAuthority.getResoucreName())
                    .append(":").append(userAuthority.getOperationName());
            set.add(stringBuffer.toString());
        }
        for (String str : set) {
            LogTemplate.debug(this.getClass(), "拥有的资源", str);
        }
        return set;
    }

    @Override
    public Set<String> getUserRole(User user) {
        List<Role> roles = roleMapper.selectByUser(user);
        Set<String> set = new HashSet<>();
        for (Role role : roles) {
            set.add(role.getRoleName());
        }
        for (String str : set) {
            LogTemplate.debug(this.getClass(), "拥有的角色", str);
        }
        return set;
    }

    @Override
    public ResultTo updatePassword(String oldPassword, String newPassword) {
        User user = (User) ShiroKit.getPrincipal();
        if (!user.getPassword().equals(PasswordUtil.encryptPassword(oldPassword))) {
            LogTemplate.debug(this.getClass(), "oldPassword(数据库)", user.getPassword());
            LogTemplate.debug(this.getClass(), "oldPassword(传入)", PasswordUtil.encryptPassword(oldPassword));
            return new ResultTo(ResultEnum.OLD_PASSWORD_ERROR.getValue());
        }
        user = new User();
        user.setPassword(PasswordUtil.encryptPassword(newPassword));
        if (userMapper.updateByPrimaryKeySelective(user) == 0) {
            LogTemplate.info(this.getClass(), "message", "修改密码失败");
            return new ResultTo(ResultEnum.OPERATION_FAILED.getValue());
        }
        return new ResultTo();
    }
}
