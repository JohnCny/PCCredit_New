package com.cardpay.mgt.index.model;

/**
 * 机构进件信息
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/7 15:35
 */
public class Org {

    /**
     * 机构id
     */
    private Integer orgId;

    /**
     * 机构名称
     */
    private String orgName;

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
}
