package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserAuthority;
import com.cardpay.mgt.user.model.UserRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户Dao层接口
 *
 * @author rankai
 */
public interface UserMapper extends BasicMapper<User> {
    /**
     * 根据用户ID获取用户权限信息
     *
     * @param user 用户对象
     * @return 资源权限集合
     */
    List<UserAuthority> selectByAuthority(User user);
}