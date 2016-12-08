package com.cardpay.basic.base.excel.impl;

import com.cardpay.basic.base.excel.BaseExcel;
import com.cardpay.basic.base.excel.SheetValues;
import com.cardpay.basic.util.DateTimeUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import java.util.Date;

/**
 * 导出excel基类实现类
 * @author wangpeng
 */
public class BaseExcelImpl implements BaseExcel{

    Workbook wb = null;
    Sheet sheet = null;


    @Override
    public void uploadExcelTemp(String path, Integer modelType) throws Exception {

    }

    @Override
    public void downloadExcel(String name, Integer modelType) throws Exception {

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
