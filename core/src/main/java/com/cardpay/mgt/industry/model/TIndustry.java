package com.cardpay.mgt.industry.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_INDUSTRY")
@ApiModel(value="行业信息表")
public class TIndustry extends GenericEntity<Integer> {
    /**
     * 行业id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select INDUSTRY_SEQ.nextval from dual")
    @ApiModelProperty(value="行业id",required = true)
    private Integer id;

    /**
     * 行业名称
     */
    @Column(name = "INDUSTRY_NAME")
    @ApiModelProperty(value="行业名称",required = true)
    private String industryName;

    /**
     * 行业描述信息
     */
    @Column(name = "INDUSTRY_DESCRIPTION")
    @ApiModelProperty(value="行业描述信息",required = true)
    private String industryDescription;

    /**
     * 获取行业id
     *
     * @return ID - 行业id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置行业id
     *
     * @param id 行业id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取行业名称
     *
     * @return INDUSTRY_NAME - 行业名称
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * 设置行业名称
     *
     * @param industryName 行业名称
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    /**
     * 获取行业描述信息
     *
     * @return INDUSTRY_DESCRIPTION - 行业描述信息
     */
    public String getIndustryDescription() {
        return industryDescription;
    }

    /**
     * 设置行业描述信息
     *
     * @param industryDescription 行业描述信息
     */
    public void setIndustryDescription(String industryDescription) {
        this.industryDescription = industryDescription;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}