package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.mgt.user.model.AuthorityOperation;
import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserRole;
import org.springframework.data.repository.query.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 角色Dao层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface RoleMapper extends BasicMapper<Role> {
    /**
     * 根据用户ID获得用户角色集合
     *
     * @param user User对象
     * @return 角色集合
     */
    List<Role> selectByUser(User user);
}