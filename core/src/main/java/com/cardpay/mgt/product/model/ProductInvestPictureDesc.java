package com.cardpay.mgt.product.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 产品对应调查图片图片说明实体类
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Table(name = "T_PRODUCT_INVEST_PICTURE_DESC")
@ApiModel(value = "产品对应调查图片图片说明")
public class ProductInvestPictureDesc extends GenericEntity<Integer> {

    public ProductInvestPictureDesc() {
    }

    public ProductInvestPictureDesc(Integer id) {
        this.id = id;
    }

    /**
     * 产品调查图片说明id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select PRODUCT_INVESPIC_DESC_SEQ.nextval from dual")
    @ApiModelProperty(value = "产品调查图片说明id", required = true)
    private Integer id;

    /**
     * 产品id
     */
    @Column(name = "PRODUCT_ID")
    @ApiModelProperty(value = "产品id", required = true)
    private Integer productId;

    /**
     * 产品调查图片说明
     */
    @Column(name = "INVEST_PRITURE_DESCRIPTION")
    @ApiModelProperty(value = "产品调查图片说明", required = true)
    private String investPritureDescription;

    /**
     * 产品调查说明是否必须
     */
    @Column(name = "IS_NEED")
    @ApiModelProperty(value = "产品调查说明是否必须", required = true)
    private Integer isNeed;

    /**
     * 获取产品调查图片说明id
     *
     * @return ID - 产品调查图片说明id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产品调查图片说明id
     *
     * @param id 产品调查图片说明id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品id
     *
     * @return PRODUCT_ID - 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取产品调查图片说明
     *
     * @return PRITURE_DESCRIPTION - 产品调查图片说明
     */
    public String getInvestPritureDescription() {
        return investPritureDescription;
    }

    /**
     * 设置产品调查图片说明
     *
     * @param investPritureDescription 产品调查图片说明
     */
    public void setInvestPritureDescription(String investPritureDescription) {
        this.investPritureDescription = investPritureDescription;
    }

    /**
     * 获取产品调查说明是否必须
     *
     * @return IS_NEED - 产品调查说明是否必须
     */
    public Integer getIsNeed() {
        return isNeed;
    }

    /**
     * 设置产品调查说明是否必须
     *
     * @param isNeed 产品调查说明是否必须
     */
    public void setIsNeed(Integer isNeed) {
        this.isNeed = isNeed;
    }

    @Override
    public Integer getPK() {
        return null;
    }


}