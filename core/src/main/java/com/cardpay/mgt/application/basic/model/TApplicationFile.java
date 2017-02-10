package com.cardpay.mgt.application.basic.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_APPLICATION_FILE")
@ApiModel(value="进件相关文件")
public class TApplicationFile extends GenericEntity<Integer>{
    /**
     * 进件征信报告id
     */
    @Id
    @Column(name = "FILE_ID")
    @ApiModelProperty(value="进件征信报告id",required = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APPLICATION_FILE_SEQ.nextval from dual")
    private Integer fileId;

    /**
     * 进件征信报告文件路径
     */
    @Column(name = "FILE_URL")
    @ApiModelProperty(value="进件征信报告文件路径",required = true)
    private String fileUrl;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 文件名称
     */
    @Column(name = "FILE_NAME")
    @ApiModelProperty(value="文件名称",required = true)
    private String fileName;

    /**
     * 文件类型(pdf png jpeg...)
     */
    @Column(name = "FILE_TYPE")
    @ApiModelProperty(value="文件类型(pdf png jpeg...)",required = true)
    private String fileType;

    /**
     * 文件类别(0 征信报告  1 进件图片 2 其他)
     */
    @Column(name = "FILE_CATEGORY")
    @ApiModelProperty(value="文件类别(0 征信报告  1 进件图片 2 其他)",required = true)
    private Integer fileCategory;

    /**
     * 获取进件征信报告id
     *
     * @return FILE_ID - 进件征信报告id
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * 设置进件征信报告id
     *
     * @param fileId 进件征信报告id
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * 获取进件征信报告文件路径
     *
     * @return FILE_URL - 进件征信报告文件路径
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 设置进件征信报告文件路径
     *
     * @param fileUrl 进件征信报告文件路径
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取进件id
     *
     * @return APPLICATION_ID - 进件id
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     * 设置进件id
     *
     * @param applicationId 进件id
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取文件名称
     *
     * @return FILE_NAME - 文件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名称
     *
     * @param fileName 文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取文件类型(pdf png jpeg...)
     *
     * @return FILE_TYPE - 文件类型(pdf png jpeg...)
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 设置文件类型(pdf png jpeg...)
     *
     * @param fileType 文件类型(pdf png jpeg...)
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取文件类别(0 征信报告  1 进件图片 2 其他)
     *
     * @return FILE_CATEGORY - 文件类别(0 征信报告  1 进件图片 2 其他)
     */
    public Integer getFileCategory() {
        return fileCategory;
    }

    /**
     * 设置文件类别(0 征信报告  1 进件图片 2 其他)
     *
     * @param fileCategory 文件类别(0 征信报告  1 进件图片 2 其他)
     */
    public void setFileCategory(Integer fileCategory) {
        this.fileCategory = fileCategory;
    }

    @Override
    public Integer getPK() {
        return fileId;
    }
}