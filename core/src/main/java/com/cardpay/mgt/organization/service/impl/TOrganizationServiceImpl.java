package com.cardpay.mgt.organization.service.impl;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.organization.dao.TOrganizationMapper;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 机构service实现类
 * Created by chenkai on 2016/11/24.
 */
@Service
public class TOrganizationServiceImpl extends BaseService<TOrganization> implements TOrganizationService {
    @Autowired
    private TOrganizationMapper tOrganizationDao;

    @Override
    public List<TOrganizationVo> queryOrganization(int id, int levels) {
        tOrganizationDao.createOrganizationView(id, levels);
        return tOrganizationDao.queryOrganization(id);
    }

    @Override
    public int updateOrganization(int id, int parentId) {
        return tOrganizationDao.updateOrganization(id, parentId);
    }

    @Override
    public int deleteOrganization(int id) {
        return tOrganizationDao.deleteOrganization(id);
    }
}
