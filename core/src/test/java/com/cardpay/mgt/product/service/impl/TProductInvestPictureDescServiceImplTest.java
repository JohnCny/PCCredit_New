package com.cardpay.mgt.product.service.impl;

import com.cardpay.mgt.product.dao.TProductInvestPictureDescMapper;
import com.cardpay.mgt.product.model.TProductInvestPictureDesc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * 产品对应调查图片图片说明Services测试类
 * Created by chenkai on 2016/12/9.
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TProductInvestPictureDescServiceImpl.class})
public class TProductInvestPictureDescServiceImplTest {
    @Mock
    private TProductInvestPictureDescMapper tProductInvestPictureDescDao;

    @InjectMocks
    private TProductInvestPictureDescServiceImpl tProductInvestPictureDescService;

    @Test
    public void batchInsert() throws Exception {
        List<TProductInvestPictureDesc> list = new ArrayList<TProductInvestPictureDesc>(){
            {
                add(new TProductInvestPictureDesc());
                add(new TProductInvestPictureDesc());
                add(new TProductInvestPictureDesc());
            }
        };
        when(tProductInvestPictureDescDao.batchInsert(list)).thenReturn(3);
        int flag = tProductInvestPictureDescService.batchInsertImg(list);
        assertEquals(3, flag);
    }

}