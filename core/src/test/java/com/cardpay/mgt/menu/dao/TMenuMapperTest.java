package com.cardpay.mgt.menu.dao;

import com.cardpay.mgt.menu.model.vo.TMenuVo;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yanwe on 2016/11/29.
 */
public class TMenuMapperTest extends TestEnv{

    @Autowired
    private TMenuMapper tMenuMapper;

    @Test
    public void selectMenuList() throws Exception {
        List<TMenuVo> tMenuVos = tMenuMapper.selectMenuList(0);
        assertTrue(tMenuVos.size() > 0);
    }

    @Test
    public void createMenuView() throws Exception {
        tMenuMapper.createMenuView(0,3);
        List<TMenuVo> tMenuVos = tMenuMapper.selectMenuList(0);
        assertTrue(tMenuVos.size() > 0);
    }

    @Test
    public void recursionDelete() throws Exception {
        int result = tMenuMapper.recursionDelete(73);
        assertTrue(result > 0);
    }

}