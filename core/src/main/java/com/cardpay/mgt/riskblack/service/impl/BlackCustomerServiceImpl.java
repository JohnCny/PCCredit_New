package com.cardpay.mgt.riskblack.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.mgt.riskblack.dao.BlackCustomerMapper;
import com.cardpay.mgt.riskblack.model.BlackCustomer;
import com.cardpay.mgt.riskblack.model.vo.BlackCustomerVo;
import com.cardpay.mgt.riskblack.service.BlackCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 黑名单客户服务层实现
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 9:33
 */
@Service
public class BlackCustomerServiceImpl extends BaseServiceImpl<BlackCustomer> implements BlackCustomerService {

    @Autowired
    private BlackCustomerMapper blackCustomerMapper;

    @Override
    public List<BlackCustomerVo> blackCustomerPageList(Map<String, Object> map) {
        return blackCustomerMapper.blackCustomerPageList(map);
    }
}
