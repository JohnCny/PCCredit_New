package com.cardpay.mgt.organization.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.basic.util.treeutil.exception.TreeInitializeException;
import com.cardpay.mgt.menu.exception.EndRecursionException;
import com.cardpay.mgt.organization.dao.TOrganizationMapper;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
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
    public int deleteOrganization(int organizationId) {
        int number = tOrganizationDao.querySubsidiary(organizationId);
        int count = userOrganizationDao.queryUserOrg(organizationId);
        return number != 0 || count != 0 ? 0 : tOrganizationDao.deleteOrganization(organizationId);
    }

    @Override
    public List<TOrganizationVo> queryAll(int topId) {
        TreeUtil<TOrganizationVo> tree = new TreeUtil<>();
        List<TOrganizationVo> tOrganizationVos = tOrganizationDao.queryAll();
        if (!tOrganizationVos.isEmpty()) {
            try {
                return tree.getChildNodesByParentId(tOrganizationVos, topId);
            } catch (TreeInitializeException e) {
                e.printStackTrace();
            }
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

    @Override
    public Integer getTopOrgId(Integer orgId) {
        try {
            recursionOrgTopId(selectAll(),orgId);
        } catch (EndRecursionException e) {
            try {
                Integer topId = Integer.parseInt(e.getMessage());
                return topId;
            } catch (NumberFormatException e1) {
                e.printStackTrace();
                LogTemplate.error(e,"机构",e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<TOrganization> selectOrganization(Map<String, Object> map) {
        return tOrganizationDao.selectOrganization(map);
    }

    @Override
    public List<TOrganizationVo> queryOrgChildren(int orgId) {
        TreeUtil<TOrganizationVo> tree = new TreeUtil<>();
        List<TOrganizationVo> tOrganizations = tOrganizationDao.queryOrgChildren(orgId);
        if (!tOrganizations.isEmpty()) {
            try {
                return tree.getChildNodesByParentId(tOrganizations, 0);
            } catch (TreeInitializeException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    /**
     * 递归查询topId
     *
     * @param organizations 全部机构
     * @param orgId 需要查询的机构Id
     * @throws EndRecursionException 退出
     */
    private void recursionOrgTopId(List<TOrganization> organizations, Integer orgId) throws EndRecursionException {
        for (TOrganization organization : organizations) {
            if(organization.getId().equals(orgId)){
                if(organization.getOrgParentId().equals(0)){
                    throw new EndRecursionException(organization.getId().toString());
                } else {
                    recursionOrgTopId(organizations,organization.getOrgParentId());
                }
            }
        }
        throw new EndRecursionException("未找到顶级机构id");
    }
}
