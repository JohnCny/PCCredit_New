package com.cardpay.basic.base.excel.impl;

import com.cardpay.basic.base.excel.BaseExcel;
import com.cardpay.basic.base.excel.SheetValues;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.DateTimeUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * 导出excel基类实现类
 * @author wangpeng
 */
public class BaseExcelImpl implements BaseExcel{

    @Autowired
    LogTemplate logger;

    Workbook wb = null;
    Sheet sheet = null;


    @Override
    public void uploadExcelTemp(String path, Integer modelType) throws Exception {
        /*ExcelTemplete temp = excelTempleteService.getByAppId(applicationId);

        ExcelTemplete excelTemplete = new ExcelTemplete();

        File file = new File(path);

        FileInputStream fis = new FileInputStream(file);
        byte[] file_buff = null;
        if (fis != null) {
            int len = fis.available();
            file_buff = new byte[len];
            fis.read(file_buff);
        }

        FastDFSFile fastDFSFile = new FastDFSFile(file_buff, file.getName(), "xlsx");

        NameValuePair[] valuePairs = new NameValuePair[3];
        valuePairs[0] = new NameValuePair("fileName", fastDFSFile.getName());
        valuePairs[1] = new NameValuePair("fileExt", fastDFSFile.getExt());
        valuePairs[2] = new NameValuePair("fileLength", fastDFSFile.getLength());

        FileManager.setRequest(request);
        excelTemplete.setUploadTempleteName(FileManager.upload(fastDFSFile, valuePairs));
        excelTemplete.setDownloadTempleteName(fastDFSFile.getName());

        if(temp != null) {
            excelTemplete.setId(temp.getId());
            excelTemplete.setModel(temp.getModel());
            excelTempleteService.update(excelTemplete);
        }else{
            excelTemplete.setModel(modelType);
            excelTempleteService.add(excelTemplete);
        }*/
    }

    @Override
    public void downloadExcel(String name, Integer modelType) throws Exception {
        /*try {
            if (applicationId != null) {
                ExcelTemplete excelTemplete = excelTempleteService.getByAppId(applicationId);
                String str = excelTemplete.getUploadTempleteName();
                String [] params = str.split(",");
                FileManager.setRequest(request);
                InputStream sbs = FileManager.downLoadToFile(params[0], params[1]);
                String classPath = request.getServletContext().getRealPath("/");
                excelService.initFilePath(classPath);
                String fileName = excelService.exportExcel(applicationId, sbs);
                FileUtil.downExcelFile(fileName, request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("导出excel数据出错");
        }*/
    }

    @Override
    public void setSheetValues(String sheetName, SheetValues sv) throws Exception {
        sheet = wb.getSheet(sheetName);
        sv.setSheetValues(sheet);
    }

    @Override
    public void setCellValue(Integer row, Integer column, Object value) throws Exception {
        if(value != null) {
            if(value instanceof Date){
                sheet.getRow(row).getCell(column).setCellValue(DateTimeUtil.format((Date) value, DateTimeUtil.NORM_DATE_PATTERN));
            }else {
                sheet.getRow(row).getCell(column).setCellValue(value.toString());
            }
        }else{
            sheet.getRow(row).getCell(column).setCellValue("");
        }
    }
}
