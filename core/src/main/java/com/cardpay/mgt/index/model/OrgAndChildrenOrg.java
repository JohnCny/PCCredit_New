package com.cardpay.mgt.index.model;

import java.util.List;

/**
 * 机构进件信息
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/7 15:35
 */
public class OrgAndChildrenOrg {

    /**
     * 机构id
     */
    private Integer orgId;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构下的子机构
     */
    private List<Org> orgList;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<Org> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<Org> orgList) {
        this.orgList = orgList;
    }
}
