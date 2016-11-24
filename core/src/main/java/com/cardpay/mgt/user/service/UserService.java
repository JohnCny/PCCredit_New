package com.cardpay.mgt.user.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.user.model.User;

import java.util.Set;

/**
 * User的Service接口
 *
 * @author rankai
 */
public interface UserService extends BaseService<User> {

    Set<String> getUserAuthority(User user);
}
