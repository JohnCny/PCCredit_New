package com.cardpay.mgt.product.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.product.model.TProductInvestPictureDesc;

import java.util.List;

/**
 * 产品对应调查图片图片说明Mapper类
 * @author chekai
 */
public interface TProductInvestPictureDescMapper extends BasicMapper<TProductInvestPictureDesc> {

    /**
     * 批量插入
     * @param list 产品调查图片信息集合
     * @return 插入数量
     */
    int batchInsertImg(List<TProductInvestPictureDesc> list);
}