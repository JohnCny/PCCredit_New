package com.cardpay.mgt.customer.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 客户行业相关Vo
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/3 16:48
 */
public class TCustomerIndustryVo extends GenericEntity<Integer> {
    /**
     * 行业id
     */
    @Column(name = "INDUSTRY_ID")
    @ApiModelProperty(value="行业id",required = true)
    private Integer industryId;

    /**
     * 客户id
     */
    @Id
    @Column(name = "CUSTOMER_ID")
    @ApiModelProperty(value="客户id",required = true)
    private Integer customerId;

    /**
     * 行业名称
     */
    private String  industryName;

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    @Override
    public Integer getPK() {
        return customerId;
    }
}
