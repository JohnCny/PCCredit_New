package com.cardpay.mgt.file.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.file.dao.TFileMapper;
import com.cardpay.mgt.file.model.TFile;
import com.cardpay.mgt.file.service.TFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件Service实现类
 * Created by chenkai on 2016/11/25.
 */
@Lazy
@Service
public class TFileServiceImpl extends BaseServiceImpl<TFile> implements TFileService{

    @Autowired
    private TFileMapper tFileDao;

    @Override
    @Transactional
    public int batchInsertFile(List<TFile> list) {
        return tFileDao.batchInsertFile(list);
    }
}
