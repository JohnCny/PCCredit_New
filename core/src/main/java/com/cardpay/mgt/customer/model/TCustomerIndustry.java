package com.cardpay.mgt.customer.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * 客户所属行业实体类
 * @author yanweichen
 */
@Lazy
@Table(name = "T_CUSTOMER_INDUSTRY")
@ApiModel(value="客户行业信息表")
public class TCustomerIndustry extends GenericEntity<Integer> {
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
     * 获取行业id
     *
     * @return INDUSTRY_ID - 行业id
     */
    public Integer getIndustryId() {
        return industryId;
    }

    /**
     * 设置行业id
     *
     * @param industryId 行业id
     */
    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    /**
     * 获取客户id
     *
     * @return CUSTOMER_ID - 客户id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户id
     *
     * @param customerId 客户id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public Integer getPK() {
        return customerId;
    }
}