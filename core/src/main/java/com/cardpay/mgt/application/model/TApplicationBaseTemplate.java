package com.cardpay.mgt.application.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 进件调查表模板表
 * @author chenkai
 */
@Table(name = "T_APPLICATION_BASE_TEMPLATE")
@ApiModel(value="进件调查表模板表")
public class TApplicationBaseTemplate {
    /**
     * 资产负债基表id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APP_BASE_TEMPLATE_SEQ.nextval from dual")
    @ApiModelProperty(value="资产负债基表id",required = true)
    private Integer id;

    /**
     * 资产负债字段名称
     */
    @Column(name = "BALANCE_NAME")
    @ApiModelProperty(value="资产负债字段名称",required = true)
    private String balanceName;

    /**
     * 资产负债字段输入类型
     */
    @Column(name = "BALANCE_INPUT_TYPE")
    @ApiModelProperty(value="资产负债字段输入类型",required = true)
    private Integer balanceInputType;

    /**
     * 父字段名称
     */
    @Column(name = "PARENT_ID")
    @ApiModelProperty(value="父字段名称",required = true)
    private Integer parentId;

    /**
     * 字段值
     */
    @Column(name = "VALUE")
    @ApiModelProperty(value="字段值",required = true)
    private String value;

    /**
     * 组id,区分进件ipc信息
     */
    @Column(name = "GROUP_ID")
    @ApiModelProperty(value="组id,区分进件ipc信息",required = true)
    private Integer groupId;

    /**
     * 获取资产负债基表id
     *
     * @return ID - 资产负债基表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置资产负债基表id
     *
     * @param id 资产负债基表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取资产负债字段名称
     *
     * @return BALANCE_NAME - 资产负债字段名称
     */
    public String getBalanceName() {
        return balanceName;
    }

    /**
     * 设置资产负债字段名称
     *
     * @param balanceName 资产负债字段名称
     */
    public void setBalanceName(String balanceName) {
        this.balanceName = balanceName;
    }

    /**
     * 获取资产负债字段输入类型
     *
     * @return BALANCE_INPUT_TYPE - 资产负债字段输入类型
     */
    public Integer getBalanceInputType() {
        return balanceInputType;
    }

    /**
     * 设置资产负债字段输入类型
     *
     * @param balanceInputType 资产负债字段输入类型
     */
    public void setBalanceInputType(Integer balanceInputType) {
        this.balanceInputType = balanceInputType;
    }

    /**
     * 获取父字段名称
     *
     * @return PARENT_ID - 父字段名称
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父字段名称
     *
     * @param parentId 父字段名称
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取字段值
     *
     * @return VALUE - 字段值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置字段值
     *
     * @param value 字段值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取组id,区分进件ipc信息
     *
     * @return GROUP_ID - 组id,区分进件ipc信息
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置组id,区分进件ipc信息
     *
     * @param groupId 组id,区分进件ipc信息
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}