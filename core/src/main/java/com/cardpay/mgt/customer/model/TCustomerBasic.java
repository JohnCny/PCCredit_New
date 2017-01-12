package com.cardpay.mgt.customer.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.dozer.Mapping;
import org.springframework.context.annotation.Lazy;

import java.util.Date;
import javax.persistence.*;

/**
 * 客户基本信息实体类
 *
 * @author yanweichen
 */
@Lazy
@Table(name = "T_CUSTOMER_BASIC")
@ApiModel(value = "客户基本信息管理")
public class TCustomerBasic extends GenericEntity<Integer> {
    /**
     * 客户id(需要生成规则生成)
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select CUSTOMER_BASIC_SEQ.nextval from dual")
    @ApiModelProperty(value = "客户id(需要生成规则生成)", required = true)
    private Integer id;

    /**
     * 客户姓名
     */
    @Column(name = "CNAME")
    @ApiModelProperty(value = "客户姓名", required = true)
    private String cname;

    /**
     * 客户性别(0 男  1 女)
     */
    @Column(name = "SEX")
    @ApiModelProperty(value = "客户性别(0 男  1 女)", required = true)
    private Integer sex;

    /**
     * 证件类型(0 身份证，1 护照，2 驾驶证)
     */
    @Column(name = "CERTIFICATE_TYPE")
    @ApiModelProperty(value = "证件类型(0 身份证，1 护照，2 驾驶证)", required = true)
    private Integer certificateType;

    /**
     * 证件号码
     */
    @Column(name = "CERTIFICATE_NUMBER")
    @ApiModelProperty(value = "证件号码", required = true)
    private String certificateNumber;

    /**
     * 联系方式
     */
    @Column(name = "TEL")
    @ApiModelProperty(value = "联系方式", required = true)
    private String tel;

    /**
     * 家庭住址
     */
    @Column(name = "HOME_ADDRESS")
    @ApiModelProperty(value = "家庭住址", required = true)
    private String homeAddress;

    /**
     * 婚姻状况(0 未婚 1  已婚 2  离异  3 未知)
     */
    @Column(name = "MARRIAGE_STATUS")
    @ApiModelProperty(value = "婚姻状况(0 未婚 1  已婚 2  离异  3 未知)", required = true)
    private Integer marriageStatus;

    /**
     * 文化程度(8 博士 7  硕士 6 本科  5  大专  4 高中3  中专 2 初中 1 小学 0 文盲)
     */
    @Column(name = "EDUCATION_DEGREE")
    @ApiModelProperty(value = "文化程度(8 博士 7  硕士 6 本科  5  大专  4 高中3  中专 2 初中 1 小学 0 文盲)", required = true)
    private Integer educationDegree;

    /**
     * 用户id(用于用于登录和查看个人信息，预留)
     */
    @Column(name = "USER_ID")
    @ApiModelProperty(value = "用户id(用于用于登录和查看个人信息，预留)", required = true)
    private Integer userId;

    /**
     * 客户所属客户经理用户id
     */
    @Column(name = "CUSTOMER_MANAGER_ID")
    @ApiModelProperty(value = "客户所属客户经理用户id", required = true)
    private Integer customerManagerId;

    /**
     * 创建人id
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value = "创建人id", required = true)
    private Integer createBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    /**
     * 修改人id
     */
    @Column(name = "MODIFY_BY")
    @ApiModelProperty(value = "修改人id", required = true)
    private Integer modifyBy;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间", required = true)
    private Date modifyTime;

    /**
     * 客户状态(0正常，1 高风险用户 2 黑名单用户 3 禁用客户)
     */
    @Column(name = "CUSTOMER_STATUS")
    @ApiModelProperty(value = "(0正常，1 高风险用户  2 黑名单用户  3 高风险转黑名单审核  4 黑名单转出  5 禁用客户  6 客户移交中)", required = true)
    private Integer customerStatus;

    @Column
    private Integer ifDel;

    public Integer getIfDel() {
        return ifDel;
    }

    public void setIfDel(Integer ifDel) {
        this.ifDel = ifDel;
    }

    /**
     * 获取客户id(需要生成规则生成)
     *
     * @return ID - 客户id(需要生成规则生成)
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置客户id(需要生成规则生成)
     *
     * @param id 客户id(需要生成规则生成)
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * 获取客户姓名
     *
     * @return CNAME - 客户姓名
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置客户姓名
     *
     * @param cname 客户姓名
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * 获取客户性别(0 男  1 女)
     *
     * @return SEX - 客户性别(0 男  1 女)
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置客户性别(0 男  1 女)
     *
     * @param sex 客户性别(0 男  1 女)
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取证件类型(0 身份证，1 护照，2 驾驶证)
     *
     * @return CERTIFICATE_TYPE - 证件类型(0 身份证，1 护照，2 驾驶证)
     */
    public Integer getCertificateType() {
        return certificateType;
    }

    /**
     * 设置证件类型(0 身份证，1 护照，2 驾驶证)
     *
     * @param certificateType 证件类型(0 身份证，1 护照，2 驾驶证)
     */
    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    /**
     * 获取证件号码
     *
     * @return CERTIFICATE_NUMBER - 证件号码
     */
    public String getCertificateNumber() {
        return certificateNumber;
    }

    /**
     * 设置证件号码
     *
     * @param certificateNumber 证件号码
     */
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    /**
     * 获取联系方式
     *
     * @return TEL - 联系方式
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系方式
     *
     * @param tel 联系方式
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取家庭住址
     *
     * @return HOME_ADDRESS - 家庭住址
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 设置家庭住址
     *
     * @param homeAddress 家庭住址
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * 获取婚姻状况(0 未婚 1  已婚 2  离异  3 未知)
     *
     * @return MARRIAGE_STATUS - 婚姻状况(0 未婚 1  已婚 2  离异  3 未知)
     */
    public Integer getMarriageStatus() {
        return marriageStatus;
    }

    /**
     * 设置婚姻状况(0 未婚 1  已婚 2  离异  3 未知)
     *
     * @param marriageStatus 婚姻状况(0 未婚 1  已婚 2  离异  3 未知)
     */
    public void setMarriageStatus(Integer marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    /**
     * 获取文化程度(8 博士 7  硕士 6 本科  5  大专  4 高中3  中专 2 初中 1 小学 0 文盲)
     *
     * @return EDUCATION_DEGREE - 文化程度(8 博士 7  硕士 6 本科  5  大专  4 高中3  中专 2 初中 1 小学 0 文盲)
     */
    public Integer getEducationDegree() {
        return educationDegree;
    }

    /**
     * 设置文化程度(8 博士 7  硕士 6 本科  5  大专  4 高中3  中专 2 初中 1 小学 0 文盲)
     *
     * @param educationDegree 文化程度(8 博士 7  硕士 6 本科  5  大专  4 高中3  中专 2 初中 1 小学 0 文盲)
     */
    public void setEducationDegree(Integer educationDegree) {
        this.educationDegree = educationDegree;
    }

    /**
     * 获取用户id(用于用于登录和查看个人信息，预留)
     *
     * @return USER_ID - 用户id(用于用于登录和查看个人信息，预留)
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id(用于用于登录和查看个人信息，预留)
     *
     * @param userId 用户id(用于用于登录和查看个人信息，预留)
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取客户所属客户经理用户id
     *
     * @return CUSTOMER_MANAGER_ID - 客户所属客户经理用户id
     */
    public Integer getCustomerManagerId() {
        return customerManagerId;
    }

    /**
     * 设置客户所属客户经理用户id
     *
     * @param customerManagerId 客户所属客户经理用户id
     */
    public void setCustomerManagerId(Integer customerManagerId) {
        this.customerManagerId = customerManagerId;
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

    /**
     * 获取修改人id
     *
     * @return MODIFY_BY - 修改人id
     */
    public Integer getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置修改人id
     *
     * @param modifyBy 修改人id
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

    /**
     * 获取客户状态(0正常，1 高风险用户 2 黑名单用户 3 禁用客户)
     *
     * @return CUSTOMER_STATUS - 客户状态(0正常，1 高风险用户 2 黑名单用户 3 禁用客户)
     */
    public Integer getCustomerStatus() {
        return customerStatus;
    }

    /**
     * 设置客户状态(0正常，1 高风险用户 2 黑名单用户 3 禁用客户)
     *
     * @param customerStatus 客户状态(0正常，1 高风险用户 2 黑名单用户 3 禁用客户)
     */
    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}