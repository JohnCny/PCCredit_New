package com.cardpay.mgt.user.service;

import com.cardpay.mgt.user.model.User;

import java.util.Set;

/**
 * User的Service接口
 *
 * @author rankai
 */
public interface UserService {

    Set<String> getUserAuthority(User user);
}
