package com.cardpay.mgt.user.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.user.model.UserRole;

/**
 * 用户角色关系Service层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface UserRoleService extends BaseService<UserRole> {
    /**
     * 更新用户权限
     *
     * @param userRole UserRole对象
     * @return 成功失败
     */
    boolean updateUserRole(UserRole userRole);
}
