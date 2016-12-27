package com.cardpay.mgt.file.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.context.annotation.Lazy;

import java.util.Date;
import javax.persistence.*;

/**
 * 文件上传类
 * @author chenkai
 */
@Lazy
@Api("文件上传类")
@Table(name = "T_FILE")
public class TFile extends GenericEntity<Integer>{
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
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_AT")
    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    /**
     * 修改人
     */
    @Column(name = "MODIFY_BY")
    @ApiModelProperty(value = "修改人")
    private String modifyBy;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_AT")
    @ApiModelProperty(value = "修改时间")
    private Date modifyAt;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
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

    @Override
    public Integer getPK() {
        return id;
    }


    public static final class TFileBuilder {
        private Integer id;
        private String imageType;
        private String fileName;
        private String remark;
        private String createdBy;
        private Date createdAt;
        private String modifiedBy;
        private Date modifiedAt;
        private String groupName;
        private String fastName;

        private TFileBuilder() {
        }

        public static TFileBuilder get() {
            return new TFileBuilder();
        }

        public TFileBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public TFileBuilder withImageType(String imageType) {
            this.imageType = imageType;
            return this;
        }

        public TFileBuilder withFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public TFileBuilder withRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public TFileBuilder withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TFileBuilder withCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TFileBuilder withModifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public TFileBuilder withModifiedAt(Date modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public TFileBuilder withGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public TFileBuilder withFastName(String fastName) {
            this.fastName = fastName;
            return this;
        }

        public TFileBuilder but() {
            return get().withId(id).withImageType(imageType).withFileName(fileName).withRemark(remark).withCreatedBy(createdBy).withCreatedAt(createdAt).withModifiedBy(modifiedBy).withModifiedAt(modifiedAt).withGroupName(groupName).withFastName(fastName);
        }

        public TFile build() {
            TFile tFile = new TFile();
            tFile.setId(id);
            tFile.setImageType(imageType);
            tFile.setFileName(fileName);
            tFile.setRemark(remark);
            tFile.setCreateBy(createdBy);
            tFile.setCreateAt(createdAt);
            tFile.setModifyBy(modifiedBy);
            tFile.setModifyAt(modifiedAt);
            tFile.setGroupName(groupName);
            tFile.setFastName(fastName);
            return tFile;
        }
    }
}