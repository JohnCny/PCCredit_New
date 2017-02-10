package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.customer.dao.TCustomerIndustryMapper;
import com.cardpay.mgt.customer.model.TCustomerIndustry;
import com.cardpay.mgt.customer.model.vo.TCustomerIndustryVo;
import com.cardpay.mgt.customer.service.TCustomerIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 客户所属行业Service实现类
 *
 * @author chenkai 2016/12/19 10:52
 */
@Service
public class TCustomerIndustryServiceImpl extends BaseServiceImpl<TCustomerIndustry> implements TCustomerIndustryService {
    @Autowired
    private TCustomerIndustryMapper tCustomerIndustryDao;

    @Override
    @Transactional
    public int batchInsert(List<TCustomerIndustry> list) {
        return tCustomerIndustryDao.batchInsert(list);
    }

    @Override
    public List<TCustomerIndustryVo> queryById(int customerId) {
        return tCustomerIndustryDao.queryById(customerId);
    }

    @Override
    @Transactional
    public int batchUpdate(List<TCustomerIndustry> list) {
        return tCustomerIndustryDao.batchUpdate(list);
    }
}
