package com.cardpay.mgt.customermanager.basic.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户经理信息编辑页面Vo
 *
 * @author yanweichen
 */
@ApiModel(value="客户经理信息管理")
public class TCustomerManagerEditVo extends TCustomerManagerBaseVo{

    /**
     * 系统建议级别
     */
    @ApiModelProperty(value="系统建议级别",required = true)
    private String systemLevel;

    /**
     * 是否暂停进件
     */
    @ApiModelProperty(value="是否暂停进件",required = true)
    private Integer ifPause;

    /**
     * 获取是否暂停进件
     *
     * @return ifPause 是否暂停进件
     */
    public Integer getIfPause() {
        return ifPause;
    }

    /**
     * 设置是否暂停进件
     *
     * @param ifPause 是否暂停进件
     */
    public void setIfPause(Integer ifPause) {
        this.ifPause = ifPause;
    }

    /**
     * 获取系统建议级别
     *
     * @return systemLevel 系统建议级别
     */
    public String getSystemLevel() {
        return systemLevel;
    }

    /**
     * 设置系统建议级别
     *
     * @param systemLevel 系统建议级别
     */
    public void setSystemLevel(String systemLevel) {
        this.systemLevel = systemLevel;
    }

}