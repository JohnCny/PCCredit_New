package com.cardpay.mgt.product.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_PRODUCT_ORGANIZATION")
@ApiModel(value="产品机构信息对应表")
public class TProductOrganization extends GenericEntity<Integer> {
    @Column(name = "PRODUCT_ID")
    @ApiModelProperty(value="null",required = true)
    private Integer productId;

    @Column(name = "ORAGANIZATION_ID")
    @ApiModelProperty(value="null",required = true)
    private Integer oraganizationId;

    /**
     * @return PRODUCT_ID
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return ORAGANIZATION_ID
     */
    public Integer getOraganizationId() {
        return oraganizationId;
    }

    /**
     * @param oraganizationId
     */
    public void setOraganizationId(Integer oraganizationId) {
        this.oraganizationId = oraganizationId;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}