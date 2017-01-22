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
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.core.shiro.common.PasswordUtil;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.core.shiro.enums.ShiroEnum;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.menu.enums.RoleEnum;
import com.cardpay.mgt.organization.dao.TOrganizationMapper;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.user.dao.AuthorityMapper;
import com.cardpay.mgt.user.dao.RoleAuthorityMapper;
import com.cardpay.mgt.user.dao.RoleMapper;
import com.cardpay.mgt.user.dao.UserMapper;
import com.cardpay.mgt.user.dao.UserOrganizationMapper;
import com.cardpay.mgt.user.dao.UserRoleMapper;
import com.cardpay.mgt.user.model.Authority;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.RoleAuthority;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserOrganization;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.model.vo.UserUpdateVo;
import com.cardpay.mgt.user.service.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private static final String MAN_PROFILE = "/static/image/man.png";

    private static final String WOMAN_PROFILE = "/static/image/woman.png";

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

    @Autowired
    private FileManager fileManager;

    @Autowired
    private TOrganizationMapper organizationMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Override
    public Set<String> getUserAuthority(Integer userId, Integer orgId) {
        List<String> list = userMapper.selectByAuthority(userId, orgId);
        return new HashSet<>(list);
    }

    @Override
    public Set<String> getUserRole(Integer userId, Integer orgId) {
        List<String> roles = roleMapper.selectByUser(userId, orgId);
        return new HashSet<>(roles);
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
        String code;
        while (true) {
            code = VerifyCodeUtil.generateTextCode(0, 8, null);
            if (userMapper.selectOne(User.UserBuilder.get().withEmployeeNumber(code).build()) == null) {
                user.setEmployeeNumber(code);
                break;
            }
        }
        if (user.getSex() == 1) {
            user.setUserProfile(WOMAN_PROFILE);
        } else {
            user.setUserProfile(MAN_PROFILE);
        }
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
        Role role = roleMapper.selectByPrimaryKey(roleId);
        ShiroEnum roleEnum = ShiroEnum.getEnumById(role.getRoleType());
        switch (roleEnum) {
            case ADMIN:
                break;
            case MANAGER:
                TCustomerManager customerManager = new TCustomerManager();
                customerManager.setUserId(user.getId());
                customerManager.setOrganizationId(orgId);
                customerManagerService.insertSelective(customerManager);
                break;
            case EXPERT:
                break;
            case SUPER:
                break;
            default:
                break;
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateUser(User user, String[] orgIds, String[] roleIds, MultipartFile file) {
        user.setModifyBy(ShiroKit.getUserId());
        user.setModifyTime(new Date());
        if (file != null) {
            user.setUserProfile(fileManager.upLoadExt(file));
        }
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
        map.put("orgId", ShiroKit.getOrgId());
        return userMapper.userPageList(map);
    }

    @Override
    public UserUpdateVo selectUserUpdateVo(Integer userId) {
        return userMapper.selectUserUpdateVo(userId);
    }

    @Override
    public boolean addUserByOrg(User user, Integer orgId) {
        TOrganization organization = organizationMapper.selectByPrimaryKey(orgId);
        if (organization.getOrgParentId() == 0) {
            Role role = new Role();
            role.setRoleName("admin");
            role.setOrganizationId(orgId);
            role.setCreateBy(ShiroKit.getUserId());
            role.setRoleStatus(1);
            role.setRoleDescription("默认创建的admin角色");
            role.setRoleNameZh("机构管理员");
            roleMapper.insertSelective(role);
            List<Authority> authorities = authorityMapper.selectAll();
            Map<String, Object> map = new HashedMap();
            map.put("authorityIds", authorities);
            map.put("roleId", role.getId());
            roleAuthorityMapper.insertArray(map);
            addUser(user, orgId, role.getId());
        }
        return true;
    }

    @Override
    public List<User> queryRoleByOrg(Integer orgId,  Integer roleType) {
        return userMapper.queryRoleByOrg(orgId, roleType);
    }


}
