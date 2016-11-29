package com.cardpay.mgt.pdf;

import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.util.PDFTextStripper;

import java.io.*;

/**
 * Created by yanwe on 2016/11/25.
 */
public class PdfUtil {

    /**
     * 读取PDF为字符串
     * @param fis PDF文件流
     * @return
     */
    public static String readPDF(FileInputStream fis){
        try {
            PDFParser pdfParser = new PDFParser(fis);
            pdfParser.parse();
            PDFTextStripper ts = new PDFTextStripper();
            String result = ts.getText(pdfParser.getPDDocument());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
