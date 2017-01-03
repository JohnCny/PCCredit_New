package com.cardpay.mgt.product.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * 产品类型表实体类
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Table(name = "T_PRODUCT_TYPE")
@ApiModel(value = "产品类型表")
public class ProductType extends GenericEntity<Integer> {
    /**
     * 产品类型id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select PRODUCT_TYPE_SEQ.nextval from dual")
    @ApiModelProperty(value = "产品类型id", required = true)
    private Integer id;

    /**
     * 产品类型编号
     */
    @Column(name = "CODE")
    @ApiModelProperty(value = "产品类型编号", required = true)
    private Integer code;

    /**
     * 产品类型名称
     */
    @Column(name = "NAME")
    @ApiModelProperty(value = "产品类型名称", required = true)
    private String name;

    /**
     * 获取产品类型id
     *
     * @return ID - 产品类型id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产品类型id
     *
     * @param id 产品类型id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品类型编号
     *
     * @return CODE - 产品类型编号
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置产品类型编号
     *
     * @param code 产品类型编号
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取产品类型名称
     *
     * @return NAME - 产品类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品类型名称
     *
     * @param name 产品类型名称
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}