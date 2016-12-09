package com.cardpay.mgt.param.dao;

import com.cardpay.mgt.param.model.po.TBusinessParam;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.apache.coyote.http11.Constants.a;
import static org.junit.Assert.*;

/**
 * 业务参数dao测试
 * @author wangpeng
 */
public class TBusinessParamMapperTest extends TestEnv {

    @Autowired
    private TBusinessParamMapper tBusinessParamMapper;

    @Test
    public void getByName() throws Exception {
        TBusinessParam bp = new TBusinessParam();
        bp.setName("test parameter");
        bp.setNameZh("测试参数");
        bp.setValue("参数");
        bp.setDescription("测试参数");
        bp.setCreateTime(new Date());
        bp.setCreateBy(1);

        tBusinessParamMapper.insertSelective(bp);

        TBusinessParam bp2 = tBusinessParamMapper.getByName("test parameter");

        assertEquals(bp.getNameZh(), bp2.getNameZh());
        assertEquals(bp.getDescription(), bp2.getDescription());
        assertEquals(bp.getValue(), bp2.getValue());
        assertEquals(bp.getCreateBy(), bp2.getCreateBy());
        assertEquals(bp.getCreateTime(), bp2.getCreateTime());
    }

}