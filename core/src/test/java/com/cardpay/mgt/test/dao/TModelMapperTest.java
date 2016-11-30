package com.cardpay.mgt.test.dao;

import com.cardpay.mgt.test.model.TModel;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yanwe on 2016/11/17.
 */
public class TModelMapperTest extends TestEnv {

    @Autowired
    private TModelMapper tModelMapper;

    @Test
    public void test(){
        List<TModel> tModels = tModelMapper.selectAll();
        assertEquals(tModels.size(),17);
    }

}