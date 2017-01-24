package com.cardpay.basic.etc.common;

import com.cardpay.basic.common.log.LogTemplate;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * @author johnmyiqn 2017/1/23 15:08
 * 文件读写
 */
public class FileReader {
    /**
     * 字符串解析分隔符
     */
    private static final String splitStr = ",";
    /**
     *饿
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
                String[] list = FileParse.praseFile(lineTxt, splitStr);
                for (Integer index = 0; index < list.length; index++){
                    if (list[index] != null){
                        LogTemplate.info("index" + index, list[index]);
                    }
                }
            }
            //关闭文件
            bufferedReaderIn.close();
        } catch (Exception e){
            LogTemplate.info("etc文件读取失败", e.toString());
            //关闭文件
        }
    }


    /**
     * 将数据集写入txt文件,并上传到ftp指定路径
     * @param ftpPath ftp文件路径
     * @param resultList  数据集合
     */
    public static void wirteTxtFile(final String ftpPath, final List<String> resultList){
        String encoding = "utf8";
        BufferedWriter bufferedWriterOut = null;
        String filePath = "../test.txt";
        //判断标志是否为true,true则为本地文件，false为远程地址文件
        try {
                File file = new File(filePath);
                bufferedWriterOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
            //遍历写入文件数据
            for (Integer index = 0; index < resultList.size(); index++){
                LogTemplate.info("操作文件数据整行:", index.toString());
                LogTemplate.info("读取文件数据:", resultList.get(index));
                bufferedWriterOut.write(resultList.get(index));
            }
             //读取文件缓存信息并进行解析
             bufferedWriterOut.close();

            //将本地文件上传到ftp文件服务器
        } catch (Exception e){
            LogTemplate.info("etc文件读取失败", e.toString());
        }
    }

    public static void main( String argv[]){
        String filePath = "ftp://root:qkjr_420@192.168.1.118:21/doc/test.txt";
        readTxtFile(filePath,Boolean.FALSE);
    }
}
