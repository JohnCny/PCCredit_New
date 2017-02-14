package com.cardpay.mgt.datadictionary.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 数据字典实体类
 */
@Table(name = "T_DATA_DICTIONARY")
@ApiModel(value="数据字典")
public class TDataDictionary extends GenericEntity<Integer>{
    /**
     * 主键
     */
    @Id
    @Column(name = "DATA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select DATA_DICTIONARY_SEQ.nextval from dual")
    @ApiModelProperty(value="主键",required = true)
    private Integer dataId;

    /**
     * 数据字典类型
     */
    @Column(name = "DATA_TYPE")
    @ApiModelProperty(value="数据字典类型",required = true)
    private String dataType;

    /**
     * 数据字典代码
     */
    @Column(name = "DATA_CODE")
    @ApiModelProperty(value="数据字典代码",required = true)
    private String dataCode;

    /**
     * 数据字典名称
     */
    @Column(name = "DATA_NAME")
    @ApiModelProperty(value="数据字典名称",required = true)
    private String dataName;

    /**
     * 银行代码
     */
    @Column(name = "BANK_CODE")
    @ApiModelProperty(value="银行代码",required = true)
    private String bankCode;

    /**
     * 获取主键
     *
     * @return DATA_ID - 主键
     */
    public Integer getDataId() {
        return dataId;
    }

    /**
     * 设置主键
     *
     * @param dataId 主键
     */
    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    /**
     * 获取数据字典类型
     *
     * @return DATA_TYPE - 数据字典类型
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 设置数据字典类型
     *
     * @param dataType 数据字典类型
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * 获取数据字典代码
     *
     * @return DATA_CODE - 数据字典代码
     */
    public String getDataCode() {
        return dataCode;
    }

    /**
     * 设置数据字典代码
     *
     * @param dataCode 数据字典代码
     */
    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    /**
     * 获取数据字典名称
     *
     * @return DATA_NAME - 数据字典名称
     */
    public String getDataName() {
        return dataName;
    }

    /**
     * 设置数据字典名称
     *
     * @param dataName 数据字典名称
     */
    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    /**
     * 获取银行代码
     *
     * @return BANK_CODE - 银行代码
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 设置银行代码
     *
     * @param bankCode 银行代码
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Override
    public Integer getPK() {
        return dataId;
    }
}