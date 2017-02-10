package com.cardpay.mgt.application.basic.model.vo;


import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.mgt.application.basic.model.TApplicationInvestPicture;

import java.util.List;

/**
 * 进见图片Vo类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/23 9:14
 */
public class TApplicationInvestPictureVo  extends GenericEntity<Integer>{
    /**
     * 产品调查图片说明id
     */
    private Integer id;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 产品调查图片说明
     */
    private String investPictureDescription;

    /**
     * 产品调查说明是否必须
     */
    private Integer isNeed;

    /**
     * 进见图片详情
     */
    private List<TApplicationInvestPicture> pictureList;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getInvestPictureDescription() {
        return investPictureDescription;
    }

    public void setInvestPictureDescription(String investPictureDescription) {
        this.investPictureDescription = investPictureDescription;
    }

    public Integer getIsNeed() {
        return isNeed;
    }

    public void setIsNeed(Integer isNeed) {
        this.isNeed = isNeed;
    }

    public List<TApplicationInvestPicture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<TApplicationInvestPicture> pictureList) {
        this.pictureList = pictureList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}
