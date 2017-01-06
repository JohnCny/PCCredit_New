package com.cardpay.mgt.team.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.mgt.user.model.User;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/6 12:08
 */
public class UserTeamVo extends GenericEntity<Integer> {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 属于此团队的用户
     */
    private List<User> userList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public Integer getPK() {
        return userId;
    }
}
