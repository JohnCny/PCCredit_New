package com.cardpay.mgt.application.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 进件调查表模板组表
 * @author chenki
 */
@Table(name = "T_APPLICATION_TEMPLATE_GROUP")
@ApiModel(value="进件调查表模板组表")
public class TApplicationTemplateGroup {
    /**
     * 进件调查表模板组id
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APP_TEMPLATE_GROUP_SEQ.nextval from dual")
    @ApiModelProperty(value="进件调查表模板组id",required = true)
    private Integer id;

    /**
     * 模板组name
     */
    @Column(name = "GROUP_NAME")
    @ApiModelProperty(value="模板组name",required = true)
    private String groupName;

    /**
     * 模板组描述
     */
    @Column(name = "GROUP_DESCRIPTION")
    @ApiModelProperty(value="模板组描述",required = true)
    private String groupDescription;

    /**
     * 获取进件调查表模板组id
     *
     * @return ID - 进件调查表模板组id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置进件调查表模板组id
     *
     * @param id 进件调查表模板组id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取模板组name
     *
     * @return GROUP_NAME - 模板组name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置模板组name
     *
     * @param groupName 模板组name
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 获取模板组描述
     *
     * @return GROUP_DESCRIPTION - 模板组描述
     */
    public String getGroupDescription() {
        return groupDescription;
    }

    /**
     * 设置模板组描述
     *
     * @param groupDescription 模板组描述
     */
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }
}