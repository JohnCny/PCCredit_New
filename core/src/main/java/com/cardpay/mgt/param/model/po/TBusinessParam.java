package com.cardpay.mgt.param.model.po;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

/**
 * 业务参数
 * @author yanweichen
 */
@Table(name = "T_BUSINESS_PARAM")
public class TBusinessParam  extends GenericEntity<Integer> {
    /**
     * 业务参数id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BUSINESS_PARAM_SEQ.nextval from dual")
    private Integer id;

    /**
     * 业务参数名称
     */
    @ApiModelProperty(value = "业务参数名称", required = true)
    @Column(name = "NAME")
    private String name;

    /**
     * 业务参数中文名称
     */
    @ApiModelProperty(value = "业务参数中文名称", required = true)
    @Column(name = "NAME_ZH")
    private String nameZh;

    /**
     * 业务参数值
     */
    @ApiModelProperty(value = "业务参数值", required = true)
    @Column(name = "VALUE")
    private String value;

    /**
     * 业务参数详细描述
     */
    @ApiModelProperty(value = "业务参数详细描述", required = true)
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id", required = true)
    @Column(name = "CREATE_BY")
    private Integer createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true)
    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Override
    public Integer getPK() {
        return id;
    }

    /**
     * 获取业务参数id
     *
     * @return ID - 业务参数id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置业务参数id
     *
     * @param id 业务参数id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取业务参数名称
     *
     * @return NAME - 业务参数名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置业务参数名称
     *
     * @param name 业务参数名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取业务参数中文名称
     *
     * @return NAME_ZH - 业务参数中文名称
     */
    public String getNameZh() {
        return nameZh;
    }

    /**
     * 设置业务参数中文名称
     *
     * @param nameZh 业务参数中文名称
     */
    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    /**
     * 获取业务参数值
     *
     * @return VALUE - 业务参数值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置业务参数值
     *
     * @param value 业务参数值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取业务参数详细描述
     *
     * @return DESCRIPTION - 业务参数详细描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置业务参数详细描述
     *
     * @param description 业务参数详细描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取创建人id
     *
     * @return CREATE_BY - 创建人id
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人id
     *
     * @param createBy 创建人id
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}