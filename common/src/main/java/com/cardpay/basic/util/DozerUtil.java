package com.cardpay.basic.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * DozerUtil工具类
 * 获取DozerMapper, 实现po到vo的复制
 * 例如:DozerUtil.getInstance().map(po, vo);
 * Created by chenkai on 2016/11/14.
 */
public class DozerUtil {

    private DozerUtil(){}

    //使用静态内部类实现单例
    private static class DozerUtilHolder{
    private static final Mapper instance = new DozerBeanMapper();
}

    public static final Mapper getInstance() {
        return DozerUtilHolder.instance;
    }

}
