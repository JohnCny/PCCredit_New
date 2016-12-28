package com.cardpay.mgt.organization.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.mgt.organization.dao.TOrganizationMapper;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.model.vo.TreeOrgVO;
import com.cardpay.mgt.organization.service.TOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 机构service实现类
 *
 * @author chenkai on 2016/11/24.
 */
@Lazy
@Service
public class TOrganizationServiceImpl extends BaseServiceImpl<TOrganization> implements TOrganizationService {
    @Autowired
    private TOrganizationMapper tOrganizationDao;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<TOrganizationVo> queryOrganization(int parentId, int levels) {
        tOrganizationDao.createOrganizationView(parentId, levels);
        return tOrganizationDao.queryOrganization(parentId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int deleteOrganization(int organizationId) {
        return tOrganizationDao.deleteOrganization(organizationId);
    }

    @Override
    public List<TOrganizationVo> queryAll(int parentId) {
        TreeUtil<TOrganizationVo> tree = new TreeUtil<>();
        return tree.getChildNodesByParentId(tOrganizationDao.queryAll(), parentId);
    }
}
