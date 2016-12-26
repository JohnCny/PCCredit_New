package com.cardpay.mgt.organization.dao;

import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenkai on 2016/11/30.
 */
public class TOrganizationMapperTest  extends TestEnv {
    @Autowired
    private TOrganizationMapper tOrganizationDao;

    @Test
    public void createOrganizationView() throws Exception {
        tOrganizationDao.createOrganizationView(0,1);
        List<TOrganizationVo> tOrganizationVos = tOrganizationDao.queryOrganization(0);
        assertTrue(tOrganizationVos.size() > 0);
    }

    @Test
    public void queryOrganization() throws Exception {
        List<TOrganizationVo> tOrganizationVos = tOrganizationDao.queryOrganization(0);
        assertTrue(tOrganizationVos.size() > 0);
    }

    @Test
    public void deleteOrganization() throws Exception {
        int flage = tOrganizationDao.deleteOrganization(1);
        assertTrue(flage > 0);
    }

}