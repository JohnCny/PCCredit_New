package com.cardpay.mgt.index.model;

import java.util.List;

/**
 * 机构进件信息
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/7 15:35
 */
public class IndexOrgApplicationInfo {

    /**
     * 机构id
     */
    private Integer orgId;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构下的进件所有状态统计列表
     */
    private List<IndexApplicationInfo> indexApplicationInfoList;

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

    public List<IndexApplicationInfo> getIndexApplicationInfoList() {
        return indexApplicationInfoList;
    }

    public void setIndexApplicationInfoList(List<IndexApplicationInfo> indexApplicationInfoList) {
        this.indexApplicationInfoList = indexApplicationInfoList;
    }
}
