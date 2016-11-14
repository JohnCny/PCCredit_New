package com.cardpay.basic.base.model;

import com.cardpay.basic.util.DozerUtil;

import java.io.Serializable;

/**
 * mode基础实体类
 * @author johnmyiqn
 */
public abstract class GenericEntity<PK extends Serializable> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return 主键
     */
    public abstract PK getPK();


}
