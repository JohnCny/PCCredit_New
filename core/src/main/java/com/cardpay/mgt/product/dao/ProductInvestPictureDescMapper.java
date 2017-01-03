package com.cardpay.mgt.product.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.product.model.ProductInvestPictureDesc;

import java.util.List;

/**
 * 产品对应调查图片图片说明Dao层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface ProductInvestPictureDescMapper extends BasicMapper<ProductInvestPictureDesc> {

    /**
     * 批量插入
     *
     * @param list 产品调查图片信息集合
     * @return 插入数量
     */
    int batchInsertImg(List<ProductInvestPictureDesc> list);
}