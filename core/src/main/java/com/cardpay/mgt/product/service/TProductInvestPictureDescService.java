package com.cardpay.mgt.product.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.product.model.TProductInvestPictureDesc;

import java.util.List;

/**
 * 产品对应调查图片图片说明Service类
 * Created by chenkai on 2016/12/8.
 */
public interface TProductInvestPictureDescService extends BaseService<TProductInvestPictureDesc>{
    /**
     * 批量插入
     * @param list 产品调查图片信息集合
     * @return 插入数量
     */
    int batchInsertImg(List<TProductInvestPictureDesc> list);
}
