package com.cardpay.mgt.parse.service.impl;

import com.cardpay.basic.util.PdfUtil;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.mgt.file.model.TFile;
import com.cardpay.mgt.file.service.TFileService;
import com.cardpay.mgt.parse.service.ParseCreditReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 解析征信报告PDF Service
 *
 * Created by yanwe on 2016/11/30.
 */
@Service
public class ParseCreditReportServiceImpl implements ParseCreditReportService{

    @Autowired
    @Qualifier("TFileServiceImpl")
    private TFileService tFileService;

    @Override
    public void parseCreditReport(Integer applicationId) {
        //TODO:待需求确定后根据进件id获取对应文件信息
        TFile tFile = tFileService.selectByPrimaryKey(applicationId);
        InputStream inputStream = FileManager.downLoadToFile(tFile.getGroupName(), tFile.getFastName());
        try {
            String pdfStr = PdfUtil.readPDF((FileInputStream) inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
