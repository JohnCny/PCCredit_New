package com.cardpay.mgt.user.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

/**
 * 资源操作实体
 *
 * @author rankai
 */
@Table(name = "T_OPERATION")
@ApiModel(value = "资源的操作实体")
public class Operation extends GenericEntity<Integer> {
    /**
     * 操作id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select OPERATION_SEQ.nextval from dual")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    /**
     * 操作名称
     */
    @Column(name = "OPERATION_NAME")
    @ApiModelProperty(value = "操作名称")
    private String operationName;

    /**
     * 操作名称中文
     */
    @Column(name = "OPERATION_NAME_ZH")
    @ApiModelProperty(value = "操作名称中文")
    private String operationNameZh;

    /**
     * 获取操作id
     *
     * @return ID - 操作id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置操作id
     *
     * @param id 操作id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取操作名称
     *
     * @return OPERATION_NAME - 操作名称
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * 设置操作名称
     *
     * @param operationName 操作名称
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    /**
     * 获取操作名称中文
     *
     * @return OPERATION_NAME_ZH - 操作名称中文
     */
    public String getOperationNameZh() {
        return operationNameZh;
    }

    /**
     * 设置操作名称中文
     *
     * @param operationNameZh 操作名称中文
     */
    public void setOperationNameZh(String operationNameZh) {
        this.operationNameZh = operationNameZh;
    }

    @Override
    public Integer getPK() {
        return this.id;
    }
}