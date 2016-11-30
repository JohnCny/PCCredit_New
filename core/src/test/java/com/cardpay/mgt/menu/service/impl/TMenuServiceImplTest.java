package com.cardpay.mgt.menu.service.impl;

import com.cardpay.mgt.menu.dao.TMenuMapper;
import com.cardpay.mgt.menu.model.TMenuVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by yanwe on 2016/11/29.
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TMenuServiceImpl.class})
public class TMenuServiceImplTest {

    @Mock
    private TMenuMapper tMenuMapper;

    @InjectMocks
    private TMenuServiceImpl tMenuService;

    @Test
    public void selectMenuList() throws Exception {
        List<TMenuVo> tMenuVos = new ArrayList<>(3);
        TMenuVo tMenuVo = new TMenuVo();
        tMenuVos.add(tMenuVo);
        when(tMenuMapper.selectMenuList(0)).thenReturn(tMenuVos);
        List<TMenuVo> tMenuVoList = tMenuService.selectMenuList(0, 3);
        assertTrue(tMenuVoList.size() > 0);
        verify(tMenuMapper).selectMenuList(0);
    }

}