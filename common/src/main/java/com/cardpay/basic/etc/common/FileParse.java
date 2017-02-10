package com.cardpay.basic.etc.common;

/**
 * @author johnmyiqn 2017/1/23 15:10
 *         etc文件解析
 */
public class FileParse {

    /**
     * 解析文件数据行
     * @param textLine 文件数据航
     * @param splitStr 字符串分隔符 默认为空格
     */
    public static String[] praseFile(final String textLine, String splitStr){
        //字符串行不为空才进行解析
        if (textLine == null){
            return null;
        }

        //默认分割字符串为单个空格
        if (splitStr == null) splitStr = " ";

        //字符串进行解析
        String[] praseStrList = textLine.split(splitStr);

        return praseStrList;
    }
}
