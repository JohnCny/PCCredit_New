package com.cardpay.mgt.product.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.dozer.Mapping;
import org.springframework.context.annotation.Lazy;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 产品信息实体类
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Table(name = "T_PRODUCT")
@ApiModel(value = "产品管理")
public class Product extends GenericEntity<Integer> {
    /**
     * 产品id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select PRODUCT_SEQ.nextval from dual")
    @ApiModelProperty(value = "产品id", required = true)
    private Integer id;

    /**
     * 产品名称
     */
    @Column(name = "PRODUCT_NAME")
    @ApiModelProperty(value = "产品名称", required = true)
    private String productName;

    /**
     * 产品额度上限单位为元
     */
    @Column(name = "PRODUCT_LIMIT_MAX")
    @ApiModelProperty(value = "产品额度上限单位为元", required = true)
    private BigDecimal productLimitMax;

    /**
     * 产品额度下限
     */
    @Column(name = "PRODUCT_LIMIT_MIN")
    @ApiModelProperty(value = "产品额度下限", required = true)
    private BigDecimal productLimitMin;

    /**
     * 利率区间上限
     */
    @Column(name = "PRODUCT_INTEREST_MAX")
    @ApiModelProperty(value = "利率区间上限", required = true)
    private BigDecimal productInterestMax;

    /**
     * 利率区间下限
     */
    @Column(name = "PRODUCT_INTEREST_MIN")
    @ApiModelProperty(value = "利率区间下限", required = true)
    private BigDecimal productInterestMin;

    /**
     * 产品状态(0 正常, 1 关闭，2 创建中)
     */
    @Column(name = "PRODUCT_STATE")
    @ApiModelProperty(value = "产品状态(0 正常, 1 关闭，2 创建中)", required = true)
    private Integer productState;

    /**
     * 产品类型(0 传统小微，1 循环贷)
     */
    @Column(name = "PRODUCT_TYPE")
    @ApiModelProperty(value = "产品类型(0 传统小微，1 循环贷)", required = true)
    private Integer productType;

    /**
     * 产品介绍
     */
    @Column(name = "PRODUCT_DESCRIPTION")
    @ApiModelProperty(value = "产品介绍", required = true)
    private String productDescription;

    /**
     * 产品图片地址
     */
    @Column(name = "PRODUCT_PICTURE_URL")
    @ApiModelProperty(value = "产品图片地址", required = true)
    private String productPictureUrl;

    /**
     * 还款周期(天)
     */
    @Column(name = "PRODUCT_LOAN_PERIOD")
    @ApiModelProperty(value = "还款周期(天)", required = true)
    private Integer productLoanPeriod;

    /**
     * 还款方式（0 等额本金、1 等额本息、2  到期还本）
     */
    @Column(name = "PRODUCT_REPAYMENT_MODE")
    @ApiModelProperty(value = "还款方式（0 等额本金、1 等额本息、2  到期还本）", required = true)
    private Integer productRepaymentMode;

    /**
     * 申请表模板（选择系统中已有的申请表模板，选填，默认有个产品申请模板用于进件申请）
     */
    @Column(name = "PRODUCT_APPLY_TEMPLATE_ID")
    @ApiModelProperty(value = "申请表模板（选择系统中已有的申请表模板，选填，默认有个产品申请模板用于进件申请）", required = true)
    private Integer productApplyTemplateId;

    /**
     * 对应下发数据产品编号
     */
    @Column(name = "PRODUCT_SEND_PRODUCT_NUMBER")
    @ApiModelProperty(value = "对应下发数据产品编号", required = true)
    private String productSendProductNumber;

    /**
     * 户籍门槛（0 本地、1  外地、2  无限制）
     */
    @Column(name = "PRODUCT_HOUSEHOLD_LEVEL_LIMIT")
    @ApiModelProperty(value = "户籍门槛（0 本地、1  外地、2  无限制）", required = true)
    private Integer productHouseholdLevelLimit;

    /**
     * 征信门槛（1 无信用记录、2 信用良好、有少量逾期、当前有逾期，可多选）
     */
    @Column(name = "PRODUCT_CREDIT_LEVEL_LIMIT")
    @ApiModelProperty(value = "征信门槛（1 无信用记录、2 信用良好、有少量逾期、当前有逾期，可多选）", required = true)
    private String productCreditLevelLimit;

    /**
     * 产品年龄上限
     */
    @Column(name = "PRODUCT_AGE_MAX_LIMIT")
    @ApiModelProperty(value = "产品年龄上限", required = true)
    private Integer productAgeMaxLimit;

    /**
     * 产品年龄下限
     */
    @Column(name = "PRODUCT_AGE_MIN_LIMIT")
    @ApiModelProperty(value = "产品年龄下限", required = true)
    private Integer productAgeMinLimit;

    /**
     * 产品准入行业限制(下拉选择，可多选）
     */
    @Column(name = "PRODUCT_INDUSTRY_LIMIT")
    @ApiModelProperty(value = "产品准入行业限制(下拉选择，可多选）", required = true)
    private String productIndustryLimit;

    /**
     * 产品准入是否已婚(0 未婚，1 已婚)
     */
    @Column(name = "PRODUCT_MARRIAGE_LIMIT")
    @ApiModelProperty(value = "产品准入是否已婚(0 未婚，1 已婚)", required = true)
    private Integer productMarriageLimit;

    /**
     * 准入最低客户经理级别id
     */
    @Column(name = "CUSTOMER_MANAGER_LEVEL_ID")
    @ApiModelProperty(value = "准入最低客户经理级别id", required = true)
    private Integer customerManagerLevelId;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    /**
     * 创建人id
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value = "创建人id", required = true)
    private Integer createBy;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间", required = true)
    private Date modifyTime;

    /**
     * 修改人id
     */
    @Column(name = "MODIFY_BY")
    @ApiModelProperty(value = "修改人id", required = true)
    private Integer modifyBy;

    /**
     *
     */
    @Column(name = "PRODUCT_GROUP_ID")
    @ApiModelProperty(value = "产品组表id", required = true)
    private Integer productGroupId;

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
    public Integer getProductState() {
        return productState;
    }

    /**
     * 设置产品状态(0 正常, 1 关闭，2 创建中)
     *
     * @param productState 产品状态(0 正常, 1 关闭，2 创建中)
     */
    public void setProductState(Integer productState) {
        this.productState = productState;
    }

    /**
     * 获取产品类型(0 传统小微，1 循环贷)
     *
     * @return PRODUCT_TYPE - 产品类型(0 传统小微，1 循环贷)
     */
    public Integer getProductType() {
        return productType;
    }

    /**
     * 设置产品类型(0 传统小微，1 循环贷)
     *
     * @param productType 产品类型(0 传统小微，1 循环贷)
     */
    public void setProductType(Integer productType) {
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
        return this.productPictureUrl;
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
    public Integer getProductRepaymentMode() {
        return productRepaymentMode;
    }

    /**
     * 设置还款方式（0 等额本金、1 等额本息、2  到期还本）
     *
     * @param productRepaymentMode 还款方式（0 等额本金、1 等额本息、2  到期还本）
     */
    public void setProductRepaymentMode(Integer productRepaymentMode) {
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
    public Integer getProductHouseholdLevelLimit() {
        return productHouseholdLevelLimit;
    }

    /**
     * 设置户籍门槛（0 本地、1  外地、2  无限制）
     *
     * @param productHouseholdLevelLimit 户籍门槛（0 本地、1  外地、2  无限制）
     */
    public void setProductHouseholdLevelLimit(Integer productHouseholdLevelLimit) {
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
    public Integer getProductAgeMaxLimit() {
        return productAgeMaxLimit;
    }

    /**
     * 设置产品年龄上限
     *
     * @param productAgeMaxLimit 产品年龄上限
     */
    public void setProductAgeMaxLimit(Integer productAgeMaxLimit) {
        this.productAgeMaxLimit = productAgeMaxLimit;
    }

    /**
     * 获取产品年龄下限
     *
     * @return PRODUCT_AGE_MIN_LIMIT - 产品年龄下限
     */
    public Integer getProductAgeMinLimit() {
        return productAgeMinLimit;
    }

    /**
     * 设置产品年龄下限
     *
     * @param productAgeMinLimit 产品年龄下限
     */
    public void setProductAgeMinLimit(Integer productAgeMinLimit) {
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
    public Integer getProductMarriageLimit() {
        return productMarriageLimit;
    }

    /**
     * 设置产品准入是否已婚(0 未婚，1 已婚)
     *
     * @param productMarriageLimit 产品准入是否已婚(0 未婚，1 已婚)
     */
    public void setProductMarriageLimit(Integer productMarriageLimit) {
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

    public Integer getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Integer productGroupId) {
        this.productGroupId = productGroupId;
    }


    @Override
    public Integer getPK() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productLimitMax=" + productLimitMax +
                ", productLimitMin=" + productLimitMin +
                ", productInterestMax=" + productInterestMax +
                ", productInterestMin=" + productInterestMin +
                ", productState=" + productState +
                ", productType=" + productType +
                ", productDescription='" + productDescription + '\'' +
                ", productPictureUrl='" + productPictureUrl + '\'' +
                ", productLoanPeriod=" + productLoanPeriod +
                ", productRepaymentMode=" + productRepaymentMode +
                ", productApplyTemplateId=" + productApplyTemplateId +
                ", productSendProductNumber='" + productSendProductNumber + '\'' +
                ", productHouseholdLevelLimit=" + productHouseholdLevelLimit +
                ", productCreditLevelLimit='" + productCreditLevelLimit + '\'' +
                ", productAgeMaxLimit=" + productAgeMaxLimit +
                ", productAgeMinLimit=" + productAgeMinLimit +
                ", productIndustryLimit='" + productIndustryLimit + '\'' +
                ", productMarriageLimit=" + productMarriageLimit +
                ", customerManagerLevelId=" + customerManagerLevelId +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", modifyTime=" + modifyTime +
                ", modifyBy=" + modifyBy +
                '}';
    }

    public static final class ProductBuilder {
        private Integer id;
        private String productName;
        private BigDecimal productLimitMax;
        private BigDecimal productLimitMin;
        private BigDecimal productInterestMax;
        private BigDecimal productInterestMin;
        private Integer productState;
        private Integer productType;
        private String productDescription;
        private String productPictureUrl;
        private Integer productLoanPeriod;
        private Integer productRepaymentMode;
        private Integer productApplyTemplateId;
        private String productSendProductNumber;
        private Integer productHouseholdLevelLimit;
        private String productCreditLevelLimit;
        private Integer productAgeMaxLimit;
        private Integer productAgeMinLimit;
        private String productIndustryLimit;
        private Integer productMarriageLimit;
        private Integer customerManagerLevelId;
        private Date createTime;
        private Integer createBy;
        private Date modifyTime;
        private Integer modifyBy;
        private Integer productGroupId;

        private ProductBuilder() {
        }

        public static ProductBuilder get() {
            return new ProductBuilder();
        }

        public ProductBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public ProductBuilder withProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder withProductLimitMax(BigDecimal productLimitMax) {
            this.productLimitMax = productLimitMax;
            return this;
        }

        public ProductBuilder withProductLimitMin(BigDecimal productLimitMin) {
            this.productLimitMin = productLimitMin;
            return this;
        }

        public ProductBuilder withProductInterestMax(BigDecimal productInterestMax) {
            this.productInterestMax = productInterestMax;
            return this;
        }

        public ProductBuilder withProductInterestMin(BigDecimal productInterestMin) {
            this.productInterestMin = productInterestMin;
            return this;
        }

        public ProductBuilder withProductState(Integer productState) {
            this.productState = productState;
            return this;
        }

        public ProductBuilder withProductType(Integer productType) {
            this.productType = productType;
            return this;
        }

        public ProductBuilder withProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public ProductBuilder withProductPictureUrl(String productPictureUrl) {
            this.productPictureUrl = productPictureUrl;
            return this;
        }

        public ProductBuilder withProductLoanPeriod(Integer productLoanPeriod) {
            this.productLoanPeriod = productLoanPeriod;
            return this;
        }

        public ProductBuilder withProductRepaymentMode(Integer productRepaymentMode) {
            this.productRepaymentMode = productRepaymentMode;
            return this;
        }

        public ProductBuilder withProductApplyTemplateId(Integer productApplyTemplateId) {
            this.productApplyTemplateId = productApplyTemplateId;
            return this;
        }

        public ProductBuilder withProductSendProductNumber(String productSendProductNumber) {
            this.productSendProductNumber = productSendProductNumber;
            return this;
        }

        public ProductBuilder withProductHouseholdLevelLimit(Integer productHouseholdLevelLimit) {
            this.productHouseholdLevelLimit = productHouseholdLevelLimit;
            return this;
        }

        public ProductBuilder withProductCreditLevelLimit(String productCreditLevelLimit) {
            this.productCreditLevelLimit = productCreditLevelLimit;
            return this;
        }

        public ProductBuilder withProductAgeMaxLimit(Integer productAgeMaxLimit) {
            this.productAgeMaxLimit = productAgeMaxLimit;
            return this;
        }

        public ProductBuilder withProductAgeMinLimit(Integer productAgeMinLimit) {
            this.productAgeMinLimit = productAgeMinLimit;
            return this;
        }

        public ProductBuilder withProductIndustryLimit(String productIndustryLimit) {
            this.productIndustryLimit = productIndustryLimit;
            return this;
        }

        public ProductBuilder withProductMarriageLimit(Integer productMarriageLimit) {
            this.productMarriageLimit = productMarriageLimit;
            return this;
        }

        public ProductBuilder withCustomerManagerLevelId(Integer customerManagerLevelId) {
            this.customerManagerLevelId = customerManagerLevelId;
            return this;
        }

        public ProductBuilder withCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public ProductBuilder withCreateBy(Integer createBy) {
            this.createBy = createBy;
            return this;
        }

        public ProductBuilder withModifyTime(Date modifyTime) {
            this.modifyTime = modifyTime;
            return this;
        }

        public ProductBuilder withModifyBy(Integer modifyBy) {
            this.modifyBy = modifyBy;
            return this;
        }

        public ProductBuilder withProductGroupId(Integer productGroupId) {
            this.productGroupId = productGroupId;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setId(id);
            product.setProductName(productName);
            product.setProductLimitMax(productLimitMax);
            product.setProductLimitMin(productLimitMin);
            product.setProductInterestMax(productInterestMax);
            product.setProductInterestMin(productInterestMin);
            product.setProductState(productState);
            product.setProductType(productType);
            product.setProductDescription(productDescription);
            product.setProductPictureUrl(productPictureUrl);
            product.setProductLoanPeriod(productLoanPeriod);
            product.setProductRepaymentMode(productRepaymentMode);
            product.setProductApplyTemplateId(productApplyTemplateId);
            product.setProductSendProductNumber(productSendProductNumber);
            product.setProductHouseholdLevelLimit(productHouseholdLevelLimit);
            product.setProductCreditLevelLimit(productCreditLevelLimit);
            product.setProductAgeMaxLimit(productAgeMaxLimit);
            product.setProductAgeMinLimit(productAgeMinLimit);
            product.setProductIndustryLimit(productIndustryLimit);
            product.setProductMarriageLimit(productMarriageLimit);
            product.setCustomerManagerLevelId(customerManagerLevelId);
            product.setCreateTime(createTime);
            product.setCreateBy(createBy);
            product.setModifyTime(modifyTime);
            product.setModifyBy(modifyBy);
            product.setProductGroupId(productGroupId);
            return product;
        }
    }
}