package com.cardpay.mgt.menu.dao;

import com.cardpay.mgt.menu.model.TMenuAuth;
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
        List<TMenuVo> tMenuVos = tMenuMapper.selectMenuListByUserAll(0,2);
        assertTrue(tMenuVos.size() > 0);
    }

    @Test
    public void createMenuView() throws Exception {
        List<TMenuVo> tMenuVos = tMenuMapper.selectMenuListByUserLevel(0,3,2);
        assertTrue(tMenuVos.size() > 0);
    }

    @Test
    public void recursionDelete() throws Exception {
        int result = tMenuMapper.recursionDelete(75);
        assertTrue(result > 0);
    }

    @Test
    public void selectMenuListAndAuthByUser() throws Exception {
        List<TMenuAuth> tMenuAuths = tMenuMapper.selectMenuListAndAuthByUser(2);
        assertTrue(tMenuAuths.size() > 0);
    }

}