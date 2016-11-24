package com.cardpay.mgt.test.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.dozer.Mapping;

import java.util.Date;
import javax.persistence.*;

@ApiModel(value = "测试bean")
@Table(name = "t_model")
public class TModel {
    /**
     * 模型id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "测试Id", required = true)
    private Integer id;

    /**
     * 模型名称
     */
    @ApiModelProperty(value = "模型名称", required = true)
    @Mapping("modelName")
    private String name;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", required = true)
    private String remark;

    /**
     * 模型利润表有无季节性  0无季节性 ,1有季节性 
     */
    @ApiModelProperty(value = "模型利润表有无季节性  0无季节性 ,1有季节性", required = true)
    private String templete;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = true)
    @Mapping("modelType")
    private String type;

    @ApiModelProperty(value = "创建时间", required = true)
    @Column(name = "created_by")
    private Integer createdBy;

    @ApiModelProperty(value = "创建人", required = true)
    @Column(name = "created_at")
    private Date createdAt;

    @ApiModelProperty(value = "修改时间", required = true)
    @Column(name = "modified_by")
    private Integer modifiedBy;

    @ApiModelProperty(value = "修改人", required = true)
    @Column(name = "modified_at")
    private Date modifiedAt;

    /**
     * 获取模型id
     *
     * @return id - 模型id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置模型id
     *
     * @param id 模型id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取模型名称
     *
     * @return name - 模型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置模型名称
     *
     * @param name 模型名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取模型利润表有无季节性  0无季节性 ,1有季节性 
     *
     * @return templete - 模型利润表有无季节性  0无季节性 ,1有季节性 
     */
    public String getTemplete() {
        return templete;
    }

    /**
     * 设置模型利润表有无季节性  0无季节性 ,1有季节性 
     *
     * @param templete 模型利润表有无季节性  0无季节性 ,1有季节性 
     */
    public void setTemplete(String templete) {
        this.templete = templete;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

}