package com.cardpay.basic.etc.common;

import com.cardpay.basic.common.log.LogTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author johnmyiqn 2017/1/23 15:08
 * 文件读写
 */
public class FileReader {
    /**
     *
     * @param filePath 文件路径
     * @param flag 是否读取本地文件 true 本地文件 false 远程文件
     */
    public static void readTxtFile(final String filePath, final Boolean flag){
        String encoding = "utf8";
        BufferedReader bufferedReaderIn = null;
        //判断标志是否为true,true则为本地文件，false为远程地址文件
        try {
            if (flag == Boolean.TRUE) {
                File file = new File(filePath);
                bufferedReaderIn = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));

            } else { //读取远程文件数据
                URL urlfile = new URL(filePath);
                bufferedReaderIn = new BufferedReader(new InputStreamReader(urlfile.openStream()));
            }

            //读取文件缓存信息并进行解析
            String lineTxt = null;
            while ((lineTxt = bufferedReaderIn.readLine()) != null) {
                //进行数据处理
                LogTemplate.info("读取文件数据整行:", lineTxt);
                LogTemplate.info("读取文件数据分解:",null);
                String[] list = FileParse.praseFile(lineTxt, null);
                for (Integer index = 0; index < list.length; index++){
                    if (list[index] != null){
                        LogTemplate.info("index" + index, list[index]);
                    }
                }
            }
        } catch (Exception e){
            LogTemplate.info("etc文件读取失败", e.toString());
        }
    }

    public static void main( String argv[]){
        String filePath = "D:\\test.txt";
        readTxtFile(filePath,Boolean.TRUE);

//        String filePath = "ftp://@192.168.1.118/document/test.txt";
////        ftp://wangxl:1234@172.16.31.69/aaa.txt
//        readTxtFile(filePath,Boolean.FALSE);


    }
}
