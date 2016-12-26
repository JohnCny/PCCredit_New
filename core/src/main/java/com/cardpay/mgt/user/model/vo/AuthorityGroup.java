package com.cardpay.mgt.user.model.vo;

import com.cardpay.mgt.user.model.Authority;

import java.util.List;

/**
 * 权限分组信息VO
 *
 * @author rankai .
 */
public class AuthorityGroup {
    /**
     * 分组名
     */
    private String groupName;
    /**
     * 组操作集合
     */
    private List<Authority> authorityList;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}
