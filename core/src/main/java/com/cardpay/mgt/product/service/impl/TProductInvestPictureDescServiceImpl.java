package com.cardpay.mgt.product.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.product.dao.TProductInvestPictureDescMapper;
import com.cardpay.mgt.product.model.TProductInvestPictureDesc;
import com.cardpay.mgt.product.service.TProductInvestPictureDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品对应调查图片图片说明Services实现类
 * Created by chenkai on 2016/12/8.
 */
@Service
public class TProductInvestPictureDescServiceImpl extends BaseServiceImpl<TProductInvestPictureDesc> implements TProductInvestPictureDescService {
  @Autowired
  private TProductInvestPictureDescMapper tProductInvestPictureDescDao;

  @Transactional
  @Override
  public int batchInsertImg(List<TProductInvestPictureDesc> list) {
    return tProductInvestPictureDescDao.batchInsert(list);
  }
}
