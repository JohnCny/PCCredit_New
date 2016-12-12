package com.cardpay.mgt.product.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.product.dao.TProductOrganizationMapper;
import com.cardpay.mgt.product.model.TProductOrganization;
import com.cardpay.mgt.product.service.TProductOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 产品机构关联Service实现类
 * Created by chenkai on 2016/12/8.
 */
@Service
public class TProductOrganizationServiceImpl extends BaseServiceImpl<TProductOrganization> implements TProductOrganizationService {
    @Autowired
    private TProductOrganizationMapper tProductOrganizationDao;

    @Transactional
    @Override
    public int batchInsertOrg(Map<String, Object> map) {
        return tProductOrganizationDao.batchInsertOrg(map);
    }

    @Transactional
    @Override
    public int bathDeleteOrg(Map<String, Object> map) {
        return tProductOrganizationDao.bathDeleteOrg(map);
    }
}
