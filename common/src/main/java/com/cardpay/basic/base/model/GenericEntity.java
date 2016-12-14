package com.cardpay.basic.base.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
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
    @ApiModelProperty(value = "主键")
    @Transient
    public abstract PK getPK();
}
