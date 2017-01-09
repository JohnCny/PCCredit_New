package com.cardpay.mgt.file.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.mgt.file.dao.TFileMapper;
import com.cardpay.mgt.file.model.TFile;
import com.cardpay.mgt.file.service.TFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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

    @Autowired
    private FileManager fileManager;


    @Override
    @Transactional
    public int batchInsertFile(List<TFile> list) {
        return tFileDao.batchInsertFile(list);
    }

    @Override
    @Transactional
    public List<TFile> uploads(MultipartFile[] files) {
        List<String> list = fileManager.upLoad(files);
        List<TFile> fileList = new ArrayList<>();
        for (String fileName : list) {
            String[] split = fileName.split(",");
            TFile file = new TFile();
            file.setFastName(split[1]);
            TFile tFile = tFileDao.selectOne(file);
            fileList.add(tFile);
        }
        return fileList;
    }
}
