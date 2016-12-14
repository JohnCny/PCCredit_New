package com.cardpay.mgt.organization.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.mgt.organization.dao.TOrganizationMapper;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * 机构service实现类
 * Created by chenkai on 2016/11/24.
 */
@Service
public class TOrganizationServiceImpl extends BaseServiceImpl<TOrganization> implements TOrganizationService {
    @Autowired
    private TOrganizationMapper tOrganizationDao;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<TOrganizationVo> queryOrganization(int id, int levels) {
        tOrganizationDao.createOrganizationView(id, levels);
        return tOrganizationDao.queryOrganization(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int deleteOrganization(int id) {
        return tOrganizationDao.deleteOrganization(id);
    }

    @Override
    public List<TOrganizationVo> queryAll(int parentId) {
        TreeUtil<TOrganizationVo> tree = new TreeUtil<>();
        return tree.getChildNodesByParentId(tOrganizationDao.queryAll(), parentId);
    }
}
