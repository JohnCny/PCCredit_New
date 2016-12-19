package com.cardpay.basic.util;

import com.cardpay.basic.common.log.LogTemplate;
import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.util.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;

/**
 * pdf解析工具类
 * @author yanwe
 */
public class PdfUtil {

    /**
     * 读取PDF为字符串
     * @param inputStream PDF文件流
     * @return PDF字符串
     */
    public static String readPDF(InputStream inputStream){
        String result = null;
        try {
            PDFParser pdfParser = new PDFParser(inputStream);
            pdfParser.parse();
            PDFTextStripper ts = new PDFTextStripper();
            result = ts.getText(pdfParser.getPDDocument());
            inputStream.close();
        } catch (IOException e) {
            LogTemplate.error(e,"PDF转换失败！","");
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LogTemplate.error(e,"PDF转换流关闭失败！","");
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
