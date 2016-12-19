package com.cardpay.mgt.file.service.impl;

import com.cardpay.mgt.file.dao.TFileMapper;
import com.cardpay.mgt.file.model.TFile;
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
 * Created by chenkai on 2016/11/30.
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TFileServiceImpl.class})
public class TFileServiceImplTest {
    @Mock
    private TFileMapper tFileDao;

    @InjectMocks
    private TFileServiceImpl tFileService;

    @Test
    public void batchInsert() throws Exception {
        List<TFile> tFiles = new ArrayList<>();
        TFile tFile = new TFile();
        tFile.setId(1);
        TFile tFile2 = new TFile();
        tFile2.setId(1);
        tFiles.add(tFile);
        tFiles.add(tFile2);
        when(tFileDao.batchInsertFile(tFiles)).thenReturn(1);
        int flag = tFileService.batchInsertFile(tFiles);
        assertEquals(flag, 1);
    }

}