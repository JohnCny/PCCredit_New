package com.cardpay.mgt.user.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 关系实体
 *
 * @author rankai
 */
@Table(name = "T_RESOURCES")
@ApiModel(value = "资源实体")
public class Resources extends GenericEntity<Integer> {
    /**
     * 资源id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select RESOURCES_SEQ.nextval from dual")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    /**
     * 资源名称(英文)
     */
    @Column(name = "RESOUCRE_NAME")
    @ApiModelProperty(value = "资源名称(英文)")
    private String resoucreName;

    /**
     * 资源中文名称
     */
    @Column(name = "RESOUCRE_NAME_ZH")
    @ApiModelProperty(value = "资源中文名称")
    private String resoucreNameZh;

    /**
     * 资源描述信息
     */
    @Column(name = "RESOUCRE_DESCRIPTION")
    @ApiModelProperty(value = "资源描述信息")
    private String resoucreDescription;

    /**
     * 资源类型(0 页面元素，1 文件)
     */
    @Column(name = "RESOUCRE_TYPE")
    @ApiModelProperty(value = "资源类型(0 页面元素，文件)", allowableValues = "(0 页面元素，1 文件)")
    private Integer resoucreType;

    /**
     * 获取资源id
     *
     * @return ID - 资源id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置资源id
     *
     * @param id 资源id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取资源名称(英文)
     *
     * @return RESOUCRE_NAME - 资源名称(英文)
     */
    public String getResoucreName() {
        return resoucreName;
    }

    /**
     * 设置资源名称(英文)
     *
     * @param resoucreName 资源名称(英文)
     */
    public void setResoucreName(String resoucreName) {
        this.resoucreName = resoucreName;
    }

    /**
     * 获取资源中文名称
     *
     * @return RESOUCRE_NAME_ZH - 资源中文名称
     */
    public String getResoucreNameZh() {
        return resoucreNameZh;
    }

    /**
     * 设置资源中文名称
     *
     * @param resoucreNameZh 资源中文名称
     */
    public void setResoucreNameZh(String resoucreNameZh) {
        this.resoucreNameZh = resoucreNameZh;
    }

    /**
     * 获取资源描述信息
     *
     * @return RESOUCRE_DESCRIPTION - 资源描述信息
     */
    public String getResoucreDescription() {
        return resoucreDescription;
    }

    /**
     * 设置资源描述信息
     *
     * @param resoucreDescription 资源描述信息
     */
    public void setResoucreDescription(String resoucreDescription) {
        this.resoucreDescription = resoucreDescription;
    }

    /**
     * 获取资源类型(0 页面元素，文件)
     *
     * @return RESOUCRE_TYPE - 资源类型(0 页面元素，文件)
     */
    public Integer getResoucreType() {
        return resoucreType;
    }

    /**
     * 设置资源类型(0 页面元素，文件)
     *
     * @param resoucreType 资源类型(0 页面元素，文件)
     */
    public void setResoucreType(Integer resoucreType) {
        this.resoucreType = resoucreType;
    }

    @Override
    public Integer getPK() {
        return this.id;
    }
}