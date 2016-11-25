package com.cardpay.basic.base.excel;

import org.apache.poi.ss.usermodel.Sheet;

/**
 * 往excel中sheet页的写入数据回的调接口
 * @author wangpeng
 */
public interface SheetValues {
    /**
     * 向该sheet写入数据
     * @param sheet sheet页
     * @throws Exception 错误
     */
    void setSheetValues(Sheet sheet) throws Exception;
}
