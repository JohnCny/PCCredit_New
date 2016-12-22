package com.cardpay.mgt.customermanager.basic.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 客户经理信息实体类
 * @author yanweichen
 */
@ApiModel(value="客户经理信息管理")
public class TCustomerManagerListVo {

    /**
     * 客户经理id(需要生成规则生成)
     */
    @ApiModelProperty(value="客户经理id(需要生成规则生成)",required = true)
    private Integer id;

    /**
     * 客户经理姓名
     */
    @ApiModelProperty(value="客户经理姓名",required = true)
    private String cName;

    /**
     * 客户经理级别
     */
    @ApiModelProperty(value="客户经理级别",required = true)
    private String levelName;

    /**
     * 获取客户经理级别
     *
     * @return levelName - 客户经理级别
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * 设置客户经理级别
     *
     * @param levelName 客户经理级别
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * 获取客户经理id(需要生成规则生成)
     *
     * @return ID - 客户经理id(需要生成规则生成)
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置客户经理id(需要生成规则生成)
     *
     * @param id 客户经理id(需要生成规则生成)
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取客户经理姓名
     *
     * @return CNAME - 客户经理姓名
     */
    public String getcName() {
        return cName;
    }

    /**
     * 设置客户经理姓名
     *
     * @param cName 客户经理姓名
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

}