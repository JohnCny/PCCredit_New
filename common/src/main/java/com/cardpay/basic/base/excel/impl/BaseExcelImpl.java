package com.cardpay.basic.base.excel.impl;

import com.cardpay.basic.base.excel.BaseExcel;
import com.cardpay.basic.base.excel.SheetValues;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Objects;

/**
 * 导出excel基类实现类
 * @author wangpeng
 */
public class BaseExcelImpl implements BaseExcel{

    Sheet sheet = null;


    @Override
    public void uploadExcelTemp(String path, Integer modelType) throws Exception {

    }

    @Override
    public void downloadExcel(String name, Integer modelType) throws Exception {

    }

    @Override
    public void setSheetValues(String sheetName, SheetValues sv) throws Exception {

    }

    @Override
    public void setCellValue(Integer row, Integer column, Objects value) throws Exception {

    }
}
