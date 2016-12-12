package com.cardpay.mgt.product.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 产品管理
 * @author chenkai
 */
@Table(name = "T_PRODUCT")
@ApiModel(value="产品管理")
public class TProduct extends GenericEntity<Integer>{
    /**
     * 产品id
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select PRODUCSEQ.nextval from dual")
    @ApiModelProperty(value="产品id",required = true)
    private Integer id;

    /**
     * 产品名称
     */
    @Column(name = "PRODUCT_NAME")
    @ApiModelProperty(value="产品名称",required = true)
    private String productName;

    /**
     * 产品额度上限单位为元
     */
    @Column(name = "PRODUCT_LIMIT_MAX")
    @ApiModelProperty(value="产品额度上限单位为元",required = true)
    private BigDecimal productLimitMax;

    /**
     * 产品额度下限
     */
    @Column(name = "PRODUCT_LIMIT_MIN")
    @ApiModelProperty(value="产品额度下限",required = true)
    private BigDecimal productLimitMin;

    /**
     * 利率区间上限
     */
    @Column(name = "PRODUCT_INTEREST_MAX")
    @ApiModelProperty(value="利率区间上限",required = true)
    private BigDecimal productInterestMax;

    /**
     * 利率区间下限
     */
    @Column(name = "PRODUCT_INTEREST_MIN")
    @ApiModelProperty(value="利率区间下限",required = true)
    private BigDecimal productInterestMin;

    /**
     * 产品状态(0 正常, 1 关闭，2 创建中)
     */
    @Column(name = "PRODUCT_STATE")
    @ApiModelProperty(value="产品状态(0 正常, 1 关闭，2 创建中)",required = true)
    private Short productState;

    /**
     * 产品类型(0 传统小微，1 循环贷)
     */
    @Column(name = "PRODUCT_TYPE")
    @ApiModelProperty(value="产品类型(0 传统小微，1 循环贷)",required = true)
    private Short productType;

    /**
     * 产品介绍
     */
    @Column(name = "PRODUCT_DESCRIPTION")
    @ApiModelProperty(value="产品介绍",required = true)
    private String productDescription;

    /**
     * 产品图片地址
     */
    @Column(name = "PRODUCT_PICTURE_URL")
    @ApiModelProperty(value="产品图片地址",required = true)
    private String productPictureUrl;

    /**
     * 还款周期(天)
     */
    @Column(name = "PRODUCT_LOAN_PERIOD")
    @ApiModelProperty(value="还款周期(天)",required = true)
    private Integer productLoanPeriod;

    /**
     * 还款方式（0 等额本金、1 等额本息、2  到期还本）
     */
    @Column(name = "PRODUCT_REPAYMENT_MODE")
    @ApiModelProperty(value="还款方式（0 等额本金、1 等额本息、2  到期还本）",required = true)
    private Short productRepaymentMode;

    /**
     * 申请表模板（选择系统中已有的申请表模板，选填，默认有个产品申请模板用于进件申请）
     */
    @Column(name = "PRODUCT_APPLY_TEMPLATE_ID")
    @ApiModelProperty(value="申请表模板（选择系统中已有的申请表模板，选填，默认有个产品申请模板用于进件申请）",required = true)
    private Integer productApplyTemplateId;

    /**
     * 对应下发数据产品编号
     */
    @Column(name = "PRODUCT_SEND_PRODUCT_NUMBER")
    @ApiModelProperty(value="对应下发数据产品编号",required = true)
    private String productSendProductNumber;

    /**
     * 户籍门槛（0 本地、1  外地、2  无限制）
     */
    @Column(name = "PRODUCT_HOUSEHOLD_LEVEL_LIMIT")
    @ApiModelProperty(value="户籍门槛（0 本地、1  外地、2  无限制）",required = true)
    private Short productHouseholdLevelLimit;

    /**
     * 征信门槛（1 无信用记录、2 信用良好、有少量逾期、当前有逾期，可多选）
     */
    @Column(name = "PRODUCT_CREDIT_LEVEL_LIMIT")
    @ApiModelProperty(value="征信门槛（1 无信用记录、2 信用良好、有少量逾期、当前有逾期，可多选）",required = true)
    private String productCreditLevelLimit;

    /**
     * 产品年龄上限
     */
    @Column(name = "PRODUCT_AGE_MAX_LIMIT")
    @ApiModelProperty(value="产品年龄上限",required = true)
    private Short productAgeMaxLimit;

    /**
     * 产品年龄下限
     */
    @Column(name = "PRODUCT_AGE_MIN_LIMIT")
    @ApiModelProperty(value="产品年龄下限",required = true)
    private Short productAgeMinLimit;

    /**
     * 产品准入行业限制(下拉选择，可多选）
     */
    @Column(name = "PRODUCT_INDUSTRY_LIMIT")
    @ApiModelProperty(value="产品准入行业限制(下拉选择，可多选）",required = true)
    private String productIndustryLimit;

    /**
     * 产品准入是否已婚(0 未婚，1 已婚)
     */
    @Column(name = "PRODUCT_MARRIAGE_LIMIT")
    @ApiModelProperty(value="产品准入是否已婚(0 未婚，1 已婚)",required = true)
    private Short productMarriageLimit;

    /**
     * 准入最低客户经理级别id
     */
    @Column(name = "CUSTOMER_MANAGER_LEVEL_ID")
    @ApiModelProperty(value="准入最低客户经理级别id",required = true)
    private Integer customerManagerLevelId;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 创建人id
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value="创建人id",required = true)
    private Integer createBy;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value="修改时间",required = true)
    private Date modifyTime;

    /**
     * 修改人id
     */
    @Column(name = "MODIFY_BY")
    @ApiModelProperty(value="修改人id",required = true)
    private Integer modifyBy;

    /**
     * 获取产品id
     *
     * @return ID - 产品id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产品id
     *
     * @param id 产品id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品名称
     *
     * @return PRODUCT_NAME - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取产品额度上限单位为元
     *
     * @return PRODUCT_LIMIT_MAX - 产品额度上限单位为元
     */
    public BigDecimal getProductLimitMax() {
        return productLimitMax;
    }

    /**
     * 设置产品额度上限单位为元
     *
     * @param productLimitMax 产品额度上限单位为元
     */
    public void setProductLimitMax(BigDecimal productLimitMax) {
        this.productLimitMax = productLimitMax;
    }

    /**
     * 获取产品额度下限
     *
     * @return PRODUCT_LIMIT_MIN - 产品额度下限
     */
    public BigDecimal getProductLimitMin() {
        return productLimitMin;
    }

    /**
     * 设置产品额度下限
     *
     * @param productLimitMin 产品额度下限
     */
    public void setProductLimitMin(BigDecimal productLimitMin) {
        this.productLimitMin = productLimitMin;
    }

    /**
     * 获取利率区间上限
     *
     * @return PRODUCT_INTEREST_MAX - 利率区间上限
     */
    public BigDecimal getProductInterestMax() {
        return productInterestMax;
    }

    /**
     * 设置利率区间上限
     *
     * @param productInterestMax 利率区间上限
     */
    public void setProductInterestMax(BigDecimal productInterestMax) {
        this.productInterestMax = productInterestMax;
    }

    /**
     * 获取利率区间下限
     *
     * @return PRODUCT_INTEREST_MIN - 利率区间下限
     */
    public BigDecimal getProductInterestMin() {
        return productInterestMin;
    }

    /**
     * 设置利率区间下限
     *
     * @param productInterestMin 利率区间下限
     */
    public void setProductInterestMin(BigDecimal productInterestMin) {
        this.productInterestMin = productInterestMin;
    }

    /**
     * 获取产品状态(0 正常, 1 关闭，2 创建中)
     *
     * @return PRODUCT_STATE - 产品状态(0 正常, 1 关闭，2 创建中)
     */
    public Short getProductState() {
        return productState;
    }

    /**
     * 设置产品状态(0 正常, 1 关闭，2 创建中)
     *
     * @param productState 产品状态(0 正常, 1 关闭，2 创建中)
     */
    public void setProductState(Short productState) {
        this.productState = productState;
    }

    /**
     * 获取产品类型(0 传统小微，1 循环贷)
     *
     * @return PRODUCT_TYPE - 产品类型(0 传统小微，1 循环贷)
     */
    public Short getProductType() {
        return productType;
    }

    /**
     * 设置产品类型(0 传统小微，1 循环贷)
     *
     * @param productType 产品类型(0 传统小微，1 循环贷)
     */
    public void setProductType(Short productType) {
        this.productType = productType;
    }

    /**
     * 获取产品介绍
     *
     * @return PRODUCT_DESCRIPTION - 产品介绍
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * 设置产品介绍
     *
     * @param productDescription 产品介绍
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * 获取产品图片地址
     *
     * @return PRODUCT_PICTURE_URL - 产品图片地址
     */
    public String getProductPictureUrl() {
        return productPictureUrl;
    }

    /**
     * 设置产品图片地址
     *
     * @param productPictureUrl 产品图片地址
     */
    public void setProductPictureUrl(String productPictureUrl) {
        this.productPictureUrl = productPictureUrl;
    }

    /**
     * 获取还款周期(天)
     *
     * @return PRODUCT_LOAN_PERIOD - 还款周期(天)
     */
    public Integer getProductLoanPeriod() {
        return productLoanPeriod;
    }

    /**
     * 设置还款周期(天)
     *
     * @param productLoanPeriod 还款周期(天)
     */
    public void setProductLoanPeriod(Integer productLoanPeriod) {
        this.productLoanPeriod = productLoanPeriod;
    }

    /**
     * 获取还款方式（0 等额本金、1 等额本息、2  到期还本）
     *
     * @return PRODUCT_REPAYMENT_MODE - 还款方式（0 等额本金、1 等额本息、2  到期还本）
     */
    public Short getProductRepaymentMode() {
        return productRepaymentMode;
    }

    /**
     * 设置还款方式（0 等额本金、1 等额本息、2  到期还本）
     *
     * @param productRepaymentMode 还款方式（0 等额本金、1 等额本息、2  到期还本）
     */
    public void setProductRepaymentMode(Short productRepaymentMode) {
        this.productRepaymentMode = productRepaymentMode;
    }

    /**
     * 获取申请表模板（选择系统中已有的申请表模板，选填，默认有个产品申请模板用于进件申请）
     *
     * @return PRODUCT_APPLY_TEMPLATE_ID - 申请表模板（选择系统中已有的申请表模板，选填，默认有个产品申请模板用于进件申请）
     */
    public Integer getProductApplyTemplateId() {
        return productApplyTemplateId;
    }

    /**
     * 设置申请表模板（选择系统中已有的申请表模板，选填，默认有个产品申请模板用于进件申请）
     *
     * @param productApplyTemplateId 申请表模板（选择系统中已有的申请表模板，选填，默认有个产品申请模板用于进件申请）
     */
    public void setProductApplyTemplateId(Integer productApplyTemplateId) {
        this.productApplyTemplateId = productApplyTemplateId;
    }

    /**
     * 获取对应下发数据产品编号
     *
     * @return PRODUCT_SEND_PRODUCT_NUMBER - 对应下发数据产品编号
     */
    public String getProductSendProductNumber() {
        return productSendProductNumber;
    }

    /**
     * 设置对应下发数据产品编号
     *
     * @param productSendProductNumber 对应下发数据产品编号
     */
    public void setProductSendProductNumber(String productSendProductNumber) {
        this.productSendProductNumber = productSendProductNumber;
    }

    /**
     * 获取户籍门槛（0 本地、1  外地、2  无限制）
     *
     * @return PRODUCT_HOUSEHOLD_LEVEL_LIMIT - 户籍门槛（0 本地、1  外地、2  无限制）
     */
    public Short getProductHouseholdLevelLimit() {
        return productHouseholdLevelLimit;
    }

    /**
     * 设置户籍门槛（0 本地、1  外地、2  无限制）
     *
     * @param productHouseholdLevelLimit 户籍门槛（0 本地、1  外地、2  无限制）
     */
    public void setProductHouseholdLevelLimit(Short productHouseholdLevelLimit) {
        this.productHouseholdLevelLimit = productHouseholdLevelLimit;
    }

    /**
     * 获取征信门槛（1 无信用记录、2 信用良好、有少量逾期、当前有逾期，可多选）
     *
     * @return PRODUCT_CREDIT_LEVEL_LIMIT - 征信门槛（1 无信用记录、2 信用良好、有少量逾期、当前有逾期，可多选）
     */
    public String getProductCreditLevelLimit() {
        return productCreditLevelLimit;
    }

    /**
     * 设置征信门槛（1 无信用记录、2 信用良好、有少量逾期、当前有逾期，可多选）
     *
     * @param productCreditLevelLimit 征信门槛（1 无信用记录、2 信用良好、有少量逾期、当前有逾期，可多选）
     */
    public void setProductCreditLevelLimit(String productCreditLevelLimit) {
        this.productCreditLevelLimit = productCreditLevelLimit;
    }

    /**
     * 获取产品年龄上限
     *
     * @return PRODUCT_AGE_MAX_LIMIT - 产品年龄上限
     */
    public Short getProductAgeMaxLimit() {
        return productAgeMaxLimit;
    }

    /**
     * 设置产品年龄上限
     *
     * @param productAgeMaxLimit 产品年龄上限
     */
    public void setProductAgeMaxLimit(Short productAgeMaxLimit) {
        this.productAgeMaxLimit = productAgeMaxLimit;
    }

    /**
     * 获取产品年龄下限
     *
     * @return PRODUCT_AGE_MIN_LIMIT - 产品年龄下限
     */
    public Short getProductAgeMinLimit() {
        return productAgeMinLimit;
    }

    /**
     * 设置产品年龄下限
     *
     * @param productAgeMinLimit 产品年龄下限
     */
    public void setProductAgeMinLimit(Short productAgeMinLimit) {
        this.productAgeMinLimit = productAgeMinLimit;
    }

    /**
     * 获取产品准入行业限制(下拉选择，可多选）
     *
     * @return PRODUCT_INDUSTRY_LIMIT - 产品准入行业限制(下拉选择，可多选）
     */
    public String getProductIndustryLimit() {
        return productIndustryLimit;
    }

    /**
     * 设置产品准入行业限制(下拉选择，可多选）
     *
     * @param productIndustryLimit 产品准入行业限制(下拉选择，可多选）
     */
    public void setProductIndustryLimit(String productIndustryLimit) {
        this.productIndustryLimit = productIndustryLimit;
    }

    /**
     * 获取产品准入是否已婚(0 未婚，1 已婚)
     *
     * @return PRODUCT_MARRIAGE_LIMIT - 产品准入是否已婚(0 未婚，1 已婚)
     */
    public Short getProductMarriageLimit() {
        return productMarriageLimit;
    }

    /**
     * 设置产品准入是否已婚(0 未婚，1 已婚)
     *
     * @param productMarriageLimit 产品准入是否已婚(0 未婚，1 已婚)
     */
    public void setProductMarriageLimit(Short productMarriageLimit) {
        this.productMarriageLimit = productMarriageLimit;
    }

    /**
     * 获取准入最低客户经理级别id
     *
     * @return CUSTOMER_MANAGER_LEVEL_ID - 准入最低客户经理级别id
     */
    public Integer getCustomerManagerLevelId() {
        return customerManagerLevelId;
    }

    /**
     * 设置准入最低客户经理级别id
     *
     * @param customerManagerLevelId 准入最低客户经理级别id
     */
    public void setCustomerManagerLevelId(Integer customerManagerLevelId) {
        this.customerManagerLevelId = customerManagerLevelId;
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

    @Override
    public Integer getPK() {
        return null;
    }
}