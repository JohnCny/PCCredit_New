package com.cardpay.basic.util;

import org.dozer.DozerBeanMapper;

/**
 * Dozer 工具类
 * @author yanwe
 */
public class DozerUtil {

    private static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    private DozerUtil(){}
    /**
     * PO复制VO
     *
     * @param sourceBean 源Bean
     * @param voClass 目标Bean calss
     * @param <T> 返回类型
     * @return 复制结果
     */
    public static <T> T map(Object sourceBean,Class<T> voClass){
        return dozerBeanMapper.map(sourceBean,voClass);
    }

}
