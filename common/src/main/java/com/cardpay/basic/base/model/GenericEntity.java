package com.cardpay.basic.base.model;

import java.io.Serializable;

/**
 * mode基础实体类
 * @author johnmyiqn
 */
public abstract class GenericEntity<PK> implements Serializable {

    /**
     * 获取主键
     *
     * @return 主键
     */
    public abstract PK getPK();
}
