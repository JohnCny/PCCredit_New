package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserAuthority;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.model.vo.UserUpdateVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户Dao层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface UserMapper extends BasicMapper<User> {
    /**
     * 根据用户ID获取用户权限信息
     *
     * @param user 用户对象
     * @return 资源权限集合
     */
    List<UserAuthority> selectByAuthority(User user);

    /**
     * 带搜索的用户分页,自定义SQL(此处是反射应用,没有显示调用)
     *
     * @param map 参数map
     * @return 用户列表
     */
    List<User> userPageList(Map<String, Object> map);

    /**
     * 根据用户ID查询用户信息以及用户机构和角色信息
     *
     * @param userId 用户ID
     * @return 用户信息以及用户机构和角色信息
     */
    UserUpdateVo selectUserUpdateVo(Integer userId);
}