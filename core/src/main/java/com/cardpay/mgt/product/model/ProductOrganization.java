package com.cardpay.mgt.product.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * 产品机构信息对应表实体类
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Table(name = "T_PRODUCT_ORGANIZATION")
@ApiModel(value = "产品机构信息对应表")
public class ProductOrganization extends GenericEntity<Integer> {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select PRODUCT_ORGANIZATION_SEQ.nextval from dual")
    @ApiModelProperty(value = "null", required = true)
    private Integer productId;

    @Column(name = "ORAGANIZATION_ID")
    @ApiModelProperty(value = "null", required = true)
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