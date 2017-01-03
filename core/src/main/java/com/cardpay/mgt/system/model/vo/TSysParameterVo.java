package com.cardpay.mgt.system.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 系统参数Vo类
 *
 * @author chenkai
 *         createTime 2016-12-2016/12/30 9:39
 */
public class TSysParameterVo extends GenericEntity<Integer> {
    /**
     * 主键
     */
    @Id
    @ApiModelProperty(value="主键",required = true)
    private Integer id;

    /**
     * 参数名称
     */
    @ApiModelProperty(value="参数名称",required = true)
    private String parameterName;

    /**
     * 参数值
     */
    @ApiModelProperty(value="参数值",required = true)
    private String parameterValue;

    /**
     * 参数中文名
     */
    @ApiModelProperty(value="参数中文名",required = true)
    private String parameterNameZn;

    /**
     * 参数描述
     */
    @ApiModelProperty(value="参数描述",required = true)
    private String parameterDescription;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人",required = true)
    private Integer createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 修改人
     */
    @ApiModelProperty(value="修改人",required = true)
    private Integer modifyBy;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间",required = true)
    private Date modifyTime;

    /**
     * 创建人信息
     */
    private User createUser;

    /**
     * 修改人信息
     */
    private User modifyUser;

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public User getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(User modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * 获取主键
     *
     * @return ID - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取参数名称
     *
     * @return PARAMETER_NAME - 参数名称
     */
    public String getParameterName() {
        return parameterName;
    }

    /**
     * 设置参数名称
     *
     * @param parameterName 参数名称
     */
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    /**
     * 获取参数值
     *
     * @return PARAMETER_VALUE - 参数值
     */
    public String getParameterValue() {
        return parameterValue;
    }

    /**
     * 设置参数值
     *
     * @param parameterValue 参数值
     */
    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    /**
     * 获取参数中文名
     *
     * @return PARAMETER_NAME_ZN - 参数中文名
     */
    public String getParameterNameZn() {
        return parameterNameZn;
    }

    /**
     * 设置参数中文名
     *
     * @param parameterNameZn 参数中文名
     */
    public void setParameterNameZn(String parameterNameZn) {
        this.parameterNameZn = parameterNameZn;
    }

    /**
     * 获取参数描述
     *
     * @return PARAMETER_DESCRIPTION - 参数描述
     */
    public String getParameterDescription() {
        return parameterDescription;
    }

    /**
     * 设置参数描述
     *
     * @param parameterDescription 参数描述
     */
    public void setParameterDescription(String parameterDescription) {
        this.parameterDescription = parameterDescription;
    }

    /**
     * 获取创建人
     *
     * @return CREATE_BY - 创建人
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
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

    /**
     * 获取修改人
     *
     * @return MODIFY_BY - 修改人
     */
    public Integer getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置修改人
     *
     * @param modifyBy 修改人
     */
    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * 获取修改时间
     *
     * @return MODIFY_TIME - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}
