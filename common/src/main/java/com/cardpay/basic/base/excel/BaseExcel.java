package com.cardpay.basic.base.excel;

/**
 * 导出excel基类
 * @author yanweichen
 */
public interface BaseExcel {

    /**
     * 上传模板
     * @param path 模板路径
     * @param modelType 模板对应的模型号
     * @throws Exception 错误
     */
    void uploadExcelTemp(String path, Integer modelType) throws Exception;

    /**
     * 导出excel
     * @param name 导出之后的excel文件名
     * @param modelType 模型号
     * @throws Exception 错误
     */
    void downloadExcel(String name, Integer modelType) throws Exception;

    /**
     * 向sheet页中填入数据
     * @param sheetName sheet名称
     * @param sv 回调接口
     * @throws Exception 错误
     */
    void setSheetValues(String sheetName, SheetValues sv) throws Exception;

    /**
     * 向单元格中填入数据
     * @param row 行号
     * @param column 列号
     * @param value 值
     * @throws Exception 错误
     */
    void setCellValue(Integer row, Integer column, Object value) throws Exception;
}
