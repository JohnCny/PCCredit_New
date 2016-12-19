package com.cardpay.mgt.parse.service.impl;

import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.PdfUtil;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.mgt.file.model.TFile;
import com.cardpay.mgt.file.service.TFileService;
import com.cardpay.mgt.parse.service.ParseCreditReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * 解析征信报告PDF Service
 * @author yanwe on 2016/11/30.
 */
@Service
public class ParseCreditReportServiceImpl implements ParseCreditReportService{

    @Autowired
    private TFileService tFileService;

    @Autowired
    private FileManager fileManager;

    @Override
    public void parseCreditReport(Integer applicationId) {
        //TODO:待需求确定后根据进件id获取对应文件信息
        TFile tFile = tFileService.selectByPrimaryKey(applicationId);
        if(tFile == null){
            RuntimeException runtimeException = new RuntimeException("id:" + applicationId + "对应文件不存在！");
            LogTemplate.error(runtimeException,"文件不存在","id:" + applicationId + "对应文件不存在！");
            throw runtimeException;
        }
        InputStream inputStream = fileManager.downLoadToFile(tFile.getGroupName(), tFile.getFastName());
        if(inputStream == null){
            RuntimeException runtimeException = new RuntimeException("group:" + tFile.getGroupName()
                    +"fastName:"+tFile.getFastName() + "下载失败！");
            LogTemplate.error(runtimeException,"下载失败","group:" + tFile.getGroupName()
                    +"fastName:"+tFile.getFastName() + "下载失败！");
            throw runtimeException;
        }
        String pdfStr = PdfUtil.readPDF(inputStream);
        //TODO:临时打印
        LogTemplate.info("content",pdfStr);
    }
}
