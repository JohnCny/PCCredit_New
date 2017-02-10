package com.cardpay.mgt.application.basic.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.context.ContextProperty;
import com.cardpay.mgt.application.basic.dao.TApplicationFileMapper;
import com.cardpay.mgt.application.basic.model.TApplicationFile;
import com.cardpay.mgt.application.basic.service.TApplicationFileService;
import com.cardpay.mgt.file.model.TFile;
import com.cardpay.mgt.file.service.TFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * 进件文件关联表Service实现类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 10:26
 */
@Service
public class TApplicationFileServiceImpl extends BaseServiceImpl<TApplicationFile> implements TApplicationFileService {
    @Autowired
    private TApplicationFileMapper tApplicationFileDao;

    @Autowired
    private TFileService tFileService;

    @Override
    @Transactional
    public int insertFile(MultipartFile[] files, TApplicationFile tApplicationFile) {
        List<TFile> fileList = tFileService.uploads(files);
        int flag = 0;
        String serverPort = (String) ContextProperty.getContextProperty("tracker_server");
        for (TFile file : fileList) {
            tApplicationFile.setFileType(file.getImageType());
            tApplicationFile.setFileUrl(serverPort + File.separator + file.getGroupName() + File.separator + file.getFastName());
            flag = tApplicationFileDao.insertSelective(tApplicationFile);
            flag++;
        }
        return flag;
    }
}
