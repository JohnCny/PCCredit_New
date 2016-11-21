package com.cardpay.basic.util;

import com.cardpay.basic.common.context.ContextProperty;

/**
 * 根据name获取properties属性值
 * Created by johnmyiqn on 2016/11/9.
 */
public class PropertiesUtil {
    private static ContextProperty contextProperty;
    public static String getProperties(String name){
        return (String)(contextProperty.getContextProperty(name));
    }
}
