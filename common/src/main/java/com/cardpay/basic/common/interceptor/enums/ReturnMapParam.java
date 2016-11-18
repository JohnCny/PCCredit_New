package com.cardpay.basic.common.interceptor.enums;

import java.util.HashMap;

/**
 * Created by yanwe on 2016/8/30.
 * MyBatis拦截器返回Map的参数
 */
public class ReturnMapParam extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;  
  
    /** 
     * 作为Key的字段对应MapParam的Key 
     */  
    public static final String  KEY_FIELD = "mapKeyField";  
    /** 
     * 作为Value的字段对应MapParam的Key 
     */  
    public static final String VALUE_FIELD = "mapValueField";  
      
    private ReturnMapParam(){}
      
    /** 
     * 指定keyField和valueField 
     * @param keyField Map中key对应的字段 
     * @param valueField Map中value对应的字段 
     */  
    public ReturnMapParam(String keyField, String valueField) {
        this.put(KEY_FIELD, keyField);  
        this.put(VALUE_FIELD, valueField);  
    }  
      
} 