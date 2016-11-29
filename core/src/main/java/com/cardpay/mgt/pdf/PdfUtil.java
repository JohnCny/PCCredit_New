package com.cardpay.mgt.pdf;

import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.util.PDFTextStripper;

import java.io.*;

/**
 * Created by yanwe on 2016/11/25.
 */
public class PdfUtil {

    public void readPDF() throws IOException {
        FileInputStream fis   =   new   FileInputStream("F:\\task\\lerman-atem2001.pdf");
        BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\task\\pdf_change.txt"));
        PDFParser p   =   new   PDFParser(fis);
        p.parse();
        PDFTextStripper ts   =   new   PDFTextStripper();
        String   s   =   ts.getText(p.getPDDocument());
        writer.write(s);
        System.out.println(s);
        fis.close();
        writer.close();
    }
}
