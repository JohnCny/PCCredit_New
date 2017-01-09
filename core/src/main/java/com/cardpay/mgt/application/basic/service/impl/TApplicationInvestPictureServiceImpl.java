package com.cardpay.mgt.application.basic.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.context.ContextProperty;
import com.cardpay.mgt.application.basic.model.TApplicationInvestPicture;
import com.cardpay.mgt.application.basic.service.TApplicationInvestPictureService;
import com.cardpay.mgt.application.dao.TApplicationInvestPictureMapper;
import com.cardpay.mgt.file.model.TFile;
import com.cardpay.mgt.file.service.TFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 调查图片表Service实现类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 11:36
 */
@Service
public class TApplicationInvestPictureServiceImpl extends BaseServiceImpl<TApplicationInvestPicture> implements TApplicationInvestPictureService {
    @Autowired
    private TApplicationInvestPictureMapper tApplicationInvestPictureDao;

    @Autowired
    private TFileService tFileService;

    @Override
    @Transactional
    public int insertFile(MultipartFile[] files, TApplicationInvestPicture tApplicationInvestPicture) {
        String serverPort = (String) ContextProperty.getContextProperty("tracker_server");
        List<TFile> fileList = tFileService.uploads(files);
        int flag = 0;
        for (TFile file : fileList) {
            tApplicationInvestPicture.setInvestPictureUrl(serverPort + "/" + file.getGroupName() + "/"+ file.getFastName());
            flag = tApplicationInvestPictureDao.insert(tApplicationInvestPicture);
            flag++;
        }
        return flag;
    }

    @Override
    public boolean fileIfNext(int applicationId) {
        int mark = tApplicationInvestPictureDao.queryApplicationFileNext(applicationId);
        int flag = tApplicationInvestPictureDao.queryProductFileNext(applicationId);
        return mark != flag ? false : true;
    }
}
