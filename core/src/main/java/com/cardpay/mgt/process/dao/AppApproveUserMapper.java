package com.cardpay.mgt.process.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.process.model.AppApproveUser;
import com.cardpay.mgt.user.model.User;

import java.util.List;

public interface AppApproveUserMapper extends BasicMapper<AppApproveUser> {
    /**
     * 获取排序后的UserId集合
     *
     * @param users user集合
     * @return 排序后的UserId集合
     */
    List<Integer> selectOrderUser(List<User> users);
}