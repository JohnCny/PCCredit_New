package com.cardpay.mgt.organization.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.mgt.organization.dao.TOrganizationMapper;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.model.vo.TreeOrgVO;
import com.cardpay.mgt.organization.service.TOrganizationService;
import com.cardpay.mgt.team.model.TUserTeam;
import com.cardpay.mgt.team.model.Team;
import com.cardpay.mgt.user.dao.UserOrganizationMapper;
import com.cardpay.mgt.user.model.UserOrganization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private UserOrganizationMapper userOrganizationDao;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<TOrganizationVo> queryOrganization(int parentId, int levels) {
        tOrganizationDao.createOrganizationView(parentId, levels);
        return tOrganizationDao.queryOrganization(parentId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int deleteOrganization(int organizationId) {
        int number = tOrganizationDao.querySubsidiary(organizationId);
        int count = userOrganizationDao.queryUserOrg(organizationId);
        return number != 0 || count != 0 ? 0 : tOrganizationDao.deleteOrganization(organizationId);
    }

    @Override
    public List<TOrganizationVo> queryAll(Map<String, Object> map) {
        TreeUtil<TOrganizationVo> tree = new TreeUtil<>();
        List<TOrganizationVo> tOrganizationVos = tOrganizationDao.queryAll(map);
        if (!tOrganizationVos.isEmpty()) {
            return tree.getChildNodesByParentId(tOrganizationDao.queryAll(map), map.get("topId"));
        }
        return new ArrayList<>();
    }

    @Override
    public List<TOrganization> queryIfOrgPrincipal(int userId) {
        List<TOrganization> teamList = new ArrayList<>();
        //查询此用户属于那些机构
        List<UserOrganization> userOrganizations = userOrganizationDao.queryByUserId(userId);
        for (UserOrganization userOrganization : userOrganizations) {
            TOrganization tOrganization = new TOrganization();
            tOrganization.setId(userOrganization.getOrganizationId());
            TOrganization organization = tOrganizationDao.selectOne(tOrganization);
            //查询是否为此机构负责人
            int flag = tOrganizationDao.selectIfOrgPrincipal(organization.getOrgDirectorId(), userId);
            if (flag > 0) {
                teamList.add(tOrganization);
            }
        }
        return teamList;
    }

    @Override
    public boolean selectIfOrgPrincipal(int directorId, int orgId) {
        int mark = tOrganizationDao.selectIfOrgPrincipal(directorId, orgId);
        return mark > 0 ? true : false;
    }

}
