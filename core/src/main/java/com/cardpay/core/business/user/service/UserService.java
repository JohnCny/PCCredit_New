package com.cardpay.core.business.user.service;

import java.util.Set;

/**
 * Created by johnmyiqn on 2016/11/16.
 */
public interface UserService {
    User findByName(String userName);
    Set<String> getRoles(User user);
    Set<String> getPermissions(User user);
}
