package com.cardpay.mgt.file.dao;

import com.cardpay.mgt.file.model.TFile;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenkai on 2016/11/30.
 */
public class TFileMapperTest extends TestEnv{
    @Autowired
    private TFileMapper tFileDao;

    @Test
    public void batchInsert() throws Exception {
        List<TFile> list = new ArrayList<>();
        TFile tFile1 = new TFile();
        tFile1.setFileName("1");
        tFile1.setFastName("1");
        tFile1.setGroupName("1");
        tFile1.setModifyBy("1");
        tFile1.setCreateAt(new Date());
        tFile1.setCreateAt(new Date());
        tFile1.setId(1);
        tFile1.setImageType("1");
        tFile1.setRemark("1");
        tFile1.setCreateBy("1");
        TFile tFile2 = new TFile();
        tFile2.setFileName("2");
        tFile2.setFastName("2");
        tFile2.setGroupName("2");
        tFile2.setModifyBy("2");
        tFile2.setCreateAt(new Date());
        tFile2.setCreateAt(new Date());
        tFile2.setId(2);
        tFile2.setImageType("2");
        tFile2.setRemark("2");
        tFile2.setCreateBy("2");
        list.add(tFile1);
        list.add(tFile2);
        int flag = tFileDao.batchInsert(list);
        assertEquals(flag, 2);
    }

}