package com.cardpay.mgt.product.service.impl;

import com.cardpay.mgt.product.dao.ProductOrgMapper;
import com.cardpay.mgt.product.model.vo.ProductOrganizationVo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * 产品机构表插入
 * Created by chenkai on 2016/12/8.
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({ProductOrgServiceImpl.class})
public class ProductOrgServiceImplTest {
    @Mock
    private ProductOrgMapper tProductOrganizationDao;

    @InjectMocks
    private ProductOrgServiceImpl tProductOrganizationService;

    @Test
    public void batchInsert() throws Exception {
    }

    @Test
    public void bathDeleteOrg() throws Exception {
    }

    @Test
    @Ignore
    public void queryProductOrg() throws Exception {
        List<ProductOrganizationVo> list = new ArrayList<>();
        ProductOrganizationVo tProductOrganizationPo1 = new ProductOrganizationVo();
        tProductOrganizationPo1.setOrganizationId(2);
        tProductOrganizationPo1.setOrgParentId(1);
        list.add(tProductOrganizationPo1);

        ProductOrganizationVo tProductOrganizationPo = new ProductOrganizationVo();
        tProductOrganizationPo.setOrganizationId(1);
        tProductOrganizationPo.setOrgParentId(0);
        tProductOrganizationPo.setOrganizationList(list);
        List<ProductOrganizationVo> productOrganizationPoList = new ArrayList<ProductOrganizationVo>() {
            {
                add(tProductOrganizationPo);
            }
        };
        when(tProductOrganizationDao.queryProductOrg(1)).thenReturn(productOrganizationPoList);
        /*List<ProductOrganizationVo> tProductOrganizationPos = tProductOrganizationService.queryProductOrg(1, 0);
        assertTrue(tProductOrganizationPos.size() > 0);*/
    }
}