package com.cardpay.mgt.application.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_APPLICATION_INVEST_PICTURE")
@ApiModel(value="调查图片表")
public class TApplicationInvestPicture extends GenericEntity<Integer>{
    /**
     * 进件调查图片id
     */
    @Id
    @Column(name = "INVEST_PICTURE_ID")
    @ApiModelProperty(value="进件调查图片id",required = true)
    private Integer investPictureId;

    /**
     * 进件调查图片url
     */
    @Column(name = "INVEST_PICTURE_URL")
    @ApiModelProperty(value="进件调查图片url",required = true)
    private String investPictureUrl;

    /**
     * 产品调查图片id
     */
    @Column(name = "PRODUCT_INVEST_PICTURE_IDD")
    @ApiModelProperty(value="产品调查图片id",required = true)
    private Integer productInvestPictureIdd;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 产品调查图片说明
     */
    @Column(name = "PRODUCT_INVEST_PICTURE_DESC")
    @ApiModelProperty(value="产品调查图片说明",required = true)
    private String productInvestPictureDesc;

    public Integer getInvestPictureId() {
        return investPictureId;
    }

    public void setInvestPictureId(Integer investPictureId) {
        this.investPictureId = investPictureId;
    }

    public String getInvestPictureUrl() {
        return investPictureUrl;
    }

    public void setInvestPictureUrl(String investPictureUrl) {
        this.investPictureUrl = investPictureUrl;
    }

    /**
     * 获取产品调查图片id
     *
     * @return PRODUCT_INVEST_PICTURE_IDD - 产品调查图片id
     */
    public Integer getProductInvestPictureIdd() {
        return productInvestPictureIdd;
    }

    /**
     * 设置产品调查图片id
     *
     * @param productInvestPictureIdd 产品调查图片id
     */
    public void setProductInvestPictureIdd(Integer productInvestPictureIdd) {
        this.productInvestPictureIdd = productInvestPictureIdd;
    }

    /**
     * 获取进件id
     *
     * @return APPLICATION_ID - 进件id
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     * 设置进件id
     *
     * @param applicationId 进件id
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取产品调查图片说明
     *
     * @return PRODUCT_INVEST_PICTURE_DESC - 产品调查图片说明
     */
    public String getProductInvestPictureDesc() {
        return productInvestPictureDesc;
    }

    /**
     * 设置产品调查图片说明
     *
     * @param productInvestPictureDesc 产品调查图片说明
     */
    public void setProductInvestPictureDesc(String productInvestPictureDesc) {
        this.productInvestPictureDesc = productInvestPictureDesc;
    }

    @Override
    public Integer getPK() {
        return investPictureId;
    }
}