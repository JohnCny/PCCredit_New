package com.cardpay.mgt.file.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;
@Api("文件上传类")
@Table(name = "T_FILE")
public class TFile {
    /**
     * 文件id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "文件id")
    private Integer id;

    /**
     * 影像类型
     */
    @Column(name = "IMAGE_TYPE")
    @ApiModelProperty(value = "影像类型")
    private String imageType;

    /**
     * 原文件名
     */
    @Column(name = "FILE_NAME")
    @ApiModelProperty(value = "原文件名")
    private String fileName;

    /**
     * 备注说明
     */
    @Column(name = "REMARK")
    @ApiModelProperty(value = "备注说明")
    private String remark;

    /**
     * 创建人
     */
    @Column(name = "CREATED_BY")
    @ApiModelProperty(value = "创建人")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_AT")
    @ApiModelProperty(value = "创建时间")
    private Date createdAt;

    /**
     * 修改人
     */
    @Column(name = "MODIFIED_BY")
    @ApiModelProperty(value = "修改人")
    private String modifiedBy;

    /**
     * 修改时间
     */
    @Column(name = "MODIFIED_AT")
    @ApiModelProperty(value = "修改时间")
    private Date modifiedAt;

    /**
     * 组名称
     */
    @Column(name = "GROUP_NAME")
    @ApiModelProperty(value = "组名称")
    private String groupName;

    /**
     * fast文件名称
     */
    @Column(name = "FAST_NAME")
    @ApiModelProperty(value = "fast文件名称")
    private String fastName;

    /**
     * 获取文件id
     *
     * @return ID - 文件id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置文件id
     *
     * @param id 文件id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取影像类型
     *
     * @return IMAGE_TYPE - 影像类型
     */
    public String getImageType() {
        return imageType;
    }

    /**
     * 设置影像类型
     *
     * @param imageType 影像类型
     */
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取备注说明
     *
     * @return REMARK - 备注说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注说明
     *
     * @param remark 备注说明
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建人
     *
     * @return CREATED_BY - 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取创建时间
     *
     * @return CREATED_AT - 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取修改人
     *
     * @return MODIFIED_BY - 修改人
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * 设置修改人
     *
     * @param modifiedBy 修改人
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * 获取修改时间
     *
     * @return MODIFIED_AT - 修改时间
     */
    public Date getModifiedAt() {
        return modifiedAt;
    }

    /**
     * 设置修改时间
     *
     * @param modifiedAt 修改时间
     */
    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getFastName() {
        return fastName;
    }

    public void setFastName(String fastName) {
        this.fastName = fastName;
    }
}