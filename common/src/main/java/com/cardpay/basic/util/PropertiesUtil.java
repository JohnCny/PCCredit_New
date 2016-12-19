package com.cardpay.basic.util;

import com.cardpay.basic.common.context.ContextProperty;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 根据name获取properties属性值
 * @author johnmyiqn
 */
public class PropertiesUtil {
    @Autowired
    private static ContextProperty contextProperty;
    public static String getProperties(String name){
        return (String)(contextProperty.getContextProperty(name));
    }
}
