package com.cardpay.mgt.user.service.impl;


import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.Constant;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.mail.MailSend;
import com.cardpay.basic.redis.RedisClient;
import com.cardpay.basic.redis.enums.RedisKeyPrefixEnum;
import com.cardpay.basic.util.VerifyCodeUtil;
import com.cardpay.core.shiro.common.PasswordUtil;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.menu.enums.RoleEnum;
import com.cardpay.mgt.user.dao.RoleMapper;
import com.cardpay.mgt.user.dao.UserMapper;
import com.cardpay.mgt.user.dao.UserOrganizationMapper;
import com.cardpay.mgt.user.dao.UserRoleMapper;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserAuthority;
import com.cardpay.mgt.user.model.UserOrganization;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.model.vo.UserUpdateVo;
import com.cardpay.mgt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 用户Service层实现
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserOrganizationMapper userOrganizationMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private CustomerManagerService customerManagerService;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private MailSend mailSend;

    @Override
    public Set<String> getUserAuthority(User user) {
        Set<String> set = new HashSet<>();
        List<UserAuthority> list = userMapper.selectByAuthority(user);
        StringBuffer stringBuffer = new StringBuffer();
        for (UserAuthority userAuthority : list) {
            stringBuffer.append(userAuthority.getAuthorityName()).append(":").append(userAuthority.getResoucreName())
                    .append(":").append(userAuthority.getOperationName());
            set.add(stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
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
        Integer userId = ShiroKit.getUserId();
        User user = userMapper.selectByPrimaryKey(userId);
        LogTemplate.debug(this.getClass(), "userPassword", user.getPassword());
        if (!PasswordUtil.encryptPassword(oldPassword).equals(user.getPassword())) {
            LogTemplate.debug(this.getClass(), "oldPassword(数据库)", user.getPassword());
            LogTemplate.debug(this.getClass(), "oldPassword(传入)", PasswordUtil.encryptPassword(oldPassword));
            return new ResultTo(ResultEnum.OLD_PASSWORD_ERROR);
        }
        user = new User();
        user.setId(userId);
        user.setPassword(PasswordUtil.encryptPassword(newPassword));
        if (userMapper.updateByPrimaryKeySelective(user) == 0) {
            LogTemplate.info(this.getClass(), "message", "修改密码失败");
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        return new ResultTo();
    }

    @Override
    public ResultTo sendCode(String address) {
        if (Pattern.compile(Constant.REGEX_EMAIL).matcher(address).matches()) {
            LogTemplate.debug(this.getClass(), "message", "匹配到Email类型");
            User user = userMapper.selectOne(User.UserBuilder.get().withEmail(address).build());
            if (user != null && user.getEmail().equals(address)) {
                String code = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 6, null);
                LogTemplate.debug(this.getClass(), "code", code);
                redisClient.set(RedisKeyPrefixEnum.USER, user.getId().toString(), code, Constant.TIME_OUT);
                mailSend.send(user.getEmail(), code);
                return new ResultTo().setData("userId", user.getId()).setData("email", user.getEmail());
            }
            return new ResultTo(ResultEnum.BOUND_MAILBOX_ERROR);
        }
        if (Pattern.compile(Constant.REGEX_PHONE).matcher(address).matches()) {
            LogTemplate.debug(this.getClass(), "message", "匹配到Phone类型");
            User user = userMapper.selectOne(User.UserBuilder.get().withPhone(address).build());
            if (user != null && user.getTel().equals(address)) {
                String code = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 6, null);
                LogTemplate.debug(this.getClass(), "code", code);
                redisClient.set(RedisKeyPrefixEnum.USER, user.getId().toString(), code, Constant.TIME_OUT);
                //预留手机验证
                return new ResultTo().setData("userId", user.getId()).setData("phone", user.getPhone());
            }
            return new ResultTo(ResultEnum.BOUND_PHONE_ERROR);
        }
        return new ResultTo(ResultEnum.NUMBER_ERROR);
    }

    @Override
    public ResultTo checkedCode(Integer userId, String code) {
        Object object = redisClient.get(RedisKeyPrefixEnum.USER, userId.toString());
        if (object == null) {
            return new ResultTo(ResultEnum.CAPTCHA_TIMEOUT);
        }
        if (object.toString().equals(code)) {
            String checkedCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_LOWER, 16, null);
            redisClient.set(RedisKeyPrefixEnum.USER, checkedCode, userId, Constant.API_TIMEOUT);
            LogTemplate.debug(this.getClass(), "checkedCode", checkedCode);
            return new ResultTo().setData(checkedCode);
        }
        return new ResultTo(ResultEnum.CAPTCHA_ERROR);
    }

    @Override
    public ResultTo resetPassword(String checkedCode, String password) {
        Object object = redisClient.get(RedisKeyPrefixEnum.USER, checkedCode);
        if (object == null) {
            return new ResultTo(ResultEnum.API_TIMEOUT);
        }
        User user = new User();
        user.setId((Integer) object);
        user.setPassword(password);
        PasswordUtil.encryptPassword(user);
        if (userMapper.updateByPrimaryKeySelective(user) <= 0) {
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        return new ResultTo();
    }

    @Override
    public boolean addUser(User user, Integer orgId, Integer roleId) {
        user.setCreateTime(new Date());
        user.setCreateBy(ShiroKit.getUserId());

//        user.setEmployeeNumber();

        user.setPassword(PasswordUtil.encryptPassword(ShiroKit.DEFAULT_PASSWORD));
        userMapper.insertSelective(user);
        UserOrganization userOrganization = new UserOrganization();
        userOrganization.setUserId(user.getId());
        userOrganization.setOrganizationId(orgId);
        userOrganizationMapper.insertSelective(userOrganization);
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRole.setUserId(user.getId());
        userRoleMapper.insertSelective(userRole);
        switch (RoleEnum.getValueById(roleId)) {
            case ADMIN:
                break;
            case MANAGER:
                TCustomerManager customerManager = new TCustomerManager();
                customerManager.setUserId(user.getId());
                customerManager.setOrganizationId(orgId);
                customerManagerService.insert(customerManager);
                break;
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateUser(User user, String[] orgIds, String[] roleIds) {
        user.setModifyBy(ShiroKit.getUserId());
        user.setModifyTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
        if (orgIds.length != 0) {
            UserOrganization userOrganization = new UserOrganization();
            userOrganization.setUserId(user.getId());
            userOrganization.setOrganizationId(Integer.parseInt(orgIds[0]));
            userOrganizationMapper.delete(userOrganization);
            userOrganization.setOrganizationId(Integer.parseInt(orgIds[1]));
            userOrganizationMapper.insertSelective(userOrganization);
        }
        if (roleIds.length != 0) {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(Integer.parseInt(roleIds[0]));
            userRoleMapper.delete(userRole);
            userRole.setRoleId(Integer.parseInt(roleIds[1]));
            userRoleMapper.insertSelective(userRole);
        }
        return Boolean.TRUE;
    }

    @Override
    public List<User> userPageList(Map<String, Object> map) {
        return userMapper.userPageList(map);
    }

    @Override
    public UserUpdateVo selectUserUpdateVo(Integer userId) {
        return userMapper.selectUserUpdateVo(userId);
    }

}
