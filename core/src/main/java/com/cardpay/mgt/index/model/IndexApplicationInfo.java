package com.cardpay.mgt.index.model;

/**
 * 首页进件信息
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/7 14:45
 */
public class IndexApplicationInfo {

    /**
     * 数量
     */
    private Integer count;

    /**
     * 进件状态
     */
    private Integer applicationStatus;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Integer applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

}
