package com.cardpay.mgt.modeifyhistory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_MODIFY_HISTORY")
@ApiModel(value="实体修改记录")
public class TModifyHistory {
    /**
     * id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="id",required = true)
    private Integer id;

    /**
     * 模块英文名称
     */
    @Column(name = "MODULE_NAME")
    @ApiModelProperty(value="模块英文名称",required = true)
    private String moduleName;

    /**
     * 模块中文名称
     */
    @Column(name = "MODULE_NAME_ZH")
    @ApiModelProperty(value="模块中文名称",required = true)
    private String moduleNameZh;

    /**
     * 属性英文名称
     */
    @Column(name = "PROPERTY_NAME")
    @ApiModelProperty(value="属性英文名称",required = true)
    private String propertyName;

    /**
     * 属性中文名称
     */
    @Column(name = "PROPERTY_NAME_ZH")
    @ApiModelProperty(value="属性中文名称",required = true)
    private String propertyNameZh;

    /**
     * 修改之前的值
     */
    @Column(name = "BEFORE_VALUE")
    @ApiModelProperty(value="修改之前的值",required = true)
    private String beforeValue;

    /**
     * 修改之后的值
     */
    @Column(name = "AFTER_VALUE")
    @ApiModelProperty(value="修改之后的值",required = true)
    private String afterValue;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_AT")
    @ApiModelProperty(value="修改时间",required = true)
    private Date modifyAt;

    /**
     * 修改人
     */
    @Column(name = "MODIFY_BY")
    @ApiModelProperty(value="修改人",required = true)
    private Integer modifyBy;

    /**
     * 获取id
     *
     * @return ID - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取模块英文名称
     *
     * @return MODULE_NAME - 模块英文名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置模块英文名称
     *
     * @param moduleName 模块英文名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * 获取模块中文名称
     *
     * @return MODULE_NAME_ZH - 模块中文名称
     */
    public String getModuleNameZh() {
        return moduleNameZh;
    }

    /**
     * 设置模块中文名称
     *
     * @param moduleNameZh 模块中文名称
     */
    public void setModuleNameZh(String moduleNameZh) {
        this.moduleNameZh = moduleNameZh;
    }

    /**
     * 获取属性英文名称
     *
     * @return PROPERTY_NAME - 属性英文名称
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * 设置属性英文名称
     *
     * @param propertyName 属性英文名称
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * 获取属性中文名称
     *
     * @return PROPERTY_NAME_ZH - 属性中文名称
     */
    public String getPropertyNameZh() {
        return propertyNameZh;
    }

    /**
     * 设置属性中文名称
     *
     * @param propertyNameZh 属性中文名称
     */
    public void setPropertyNameZh(String propertyNameZh) {
        this.propertyNameZh = propertyNameZh;
    }

    /**
     * 获取修改之前的值
     *
     * @return BEFORE_VALUE - 修改之前的值
     */
    public String getBeforeValue() {
        return beforeValue;
    }

    /**
     * 设置修改之前的值
     *
     * @param beforeValue 修改之前的值
     */
    public void setBeforeValue(String beforeValue) {
        this.beforeValue = beforeValue;
    }

    /**
     * 获取修改之后的值
     *
     * @return AFTER_VALUE - 修改之后的值
     */
    public String getAfterValue() {
        return afterValue;
    }

    /**
     * 设置修改之后的值
     *
     * @param afterValue 修改之后的值
     */
    public void setAfterValue(String afterValue) {
        this.afterValue = afterValue;
    }

    /**
     * 获取修改时间
     *
     * @return MODIFY_AT - 修改时间
     */
    public Date getModifyAt() {
        return modifyAt;
    }

    /**
     * 设置修改时间
     *
     * @param modifyAt 修改时间
     */
    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    /**
     * 获取修改人
     *
     * @return MODIFY_BY - 修改人
     */
    public Integer getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置修改人
     *
     * @param modifyBy 修改人
     */
    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }
}