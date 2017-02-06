package com.cardpay.mgt.application.basic.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.basic.dao.TApplicationContractMapper;
import com.cardpay.mgt.application.basic.model.TApplicationContract;
import com.cardpay.mgt.application.basic.model.vo.TApplicationContractVo;
import com.cardpay.mgt.application.basic.service.TApplicationContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 客户签约信息Service实现
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/11 10:02
 */
@Service
public class TApplicationContractServiceImpl extends BaseServiceImpl<TApplicationContract> implements TApplicationContractService {
    @Autowired
    private TApplicationContractMapper tApplicationContractDao;

    @Override
    public List<TApplicationContractVo> queryAll(Map<String, Object> map) {
        return tApplicationContractDao.queryAll(map);
    }
}
