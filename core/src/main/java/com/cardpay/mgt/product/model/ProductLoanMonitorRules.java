package com.cardpay.mgt.product.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * 产品贷后监控规则管理实体类
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Table(name = "T_PRODUCT_LOAN_MONITOR_RULES")
@ApiModel(value = "产品贷后监控规则管理")
public class ProductLoanMonitorRules extends GenericEntity<Integer> {
    /**
     * 贷后监控id
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select T_PRODUCT_LOAN_MONITOR_RULES.nextval from dual")
    @ApiModelProperty(value = "贷后监控id", required = true)
    private Integer id;

    /**
     * 产品id
     */
    @Column(name = "PRODUCT_ID")
    @ApiModelProperty(value = "产品id", required = true)
    private Integer productId;

    /**
     * 放款后首次贷后监控频率(0 一周内，1 半月，2  一月内，默认一月内 1 )
     */
    @Column(name = "MONITOR_TIME_FIRST")
    @ApiModelProperty(value = "放款后首次贷后监控频率(0 一周内，1 半月，2  一月内，默认一月内 1 )", required = true)
    private Integer monitorTimeFirst;

    /**
     * 首次贷后监控后监控频率(0 每周，1 半月，2每月， 3 三个月，默认为1 )
     */
    @Column(name = "MONITOR_TIME_RATE")
    @ApiModelProperty(value = "首次贷后监控后监控频率(0 每周，1 半月，2每月， 3 三个月，默认为1 )", required = true)
    private Integer monitorTimeRate;

    /**
     * 实地回访频率(0 每月，1 三个月  2  六个月 默认为 1 )
     */
    @Column(name = "SITE_VISITSRATE")
    @ApiModelProperty(value = "实地回访频率(0 每月，1 三个月  2  六个月 默认为 1 )", required = true)
    private Integer siteVisitsrate;

    /**
     * 电话催收频率(0 每天 1 每周  2 每月)
     */
    @Column(name = "PHONE_COLLECTION_RATE")
    @ApiModelProperty(value = "电话催收频率(0 每天 1 每周  2 每月)", required = true)
    private Integer phoneCollectionRate;

    /**
     * 上门催收频率(0 每天 1 每周  2 每月 )
     */
    @Column(name = "HOME_COLLECTION_RATE")
    @ApiModelProperty(value = "上门催收频率(0 每天 1 每周  2 每月 )", required = true)
    private Integer homeCollectionRate;

    /**
     * 获取贷后监控id
     *
     * @return ID - 贷后监控id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置贷后监控id
     *
     * @param id 贷后监控id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品id
     *
     * @return PRODUCT_ID - 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取放款后首次贷后监控频率(0 一周内，1 半月，2  一月内，默认一月内 1 )
     *
     * @return MONITOR_TIME_FIRST - 放款后首次贷后监控频率(0 一周内，1 半月，2  一月内，默认一月内 1 )
     */
    public Integer getMonitorTimeFirst() {
        return monitorTimeFirst;
    }

    /**
     * 设置放款后首次贷后监控频率(0 一周内，1 半月，2  一月内，默认一月内 1 )
     *
     * @param monitorTimeFirst 放款后首次贷后监控频率(0 一周内，1 半月，2  一月内，默认一月内 1 )
     */
    public void setMonitorTimeFirst(Integer monitorTimeFirst) {
        this.monitorTimeFirst = monitorTimeFirst;
    }

    /**
     * 获取首次贷后监控后监控频率(0 每周，1 半月，2每月， 3 三个月，默认为1 )
     *
     * @return MONITOR_TIME_RATE - 首次贷后监控后监控频率(0 每周，1 半月，2每月， 3 三个月，默认为1 )
     */
    public Integer getMonitorTimeRate() {
        return monitorTimeRate;
    }

    /**
     * 设置首次贷后监控后监控频率(0 每周，1 半月，2每月， 3 三个月，默认为1 )
     *
     * @param monitorTimeRate 首次贷后监控后监控频率(0 每周，1 半月，2每月， 3 三个月，默认为1 )
     */
    public void setMonitorTimeRate(Integer monitorTimeRate) {
        this.monitorTimeRate = monitorTimeRate;
    }

    /**
     * 获取实地回访频率(0 每月，1 三个月  2  六个月 默认为 1 )
     *
     * @return SITE_VISITSRATE - 实地回访频率(0 每月，1 三个月  2  六个月 默认为 1 )
     */
    public Integer getSiteVisitsrate() {
        return siteVisitsrate;
    }

    /**
     * 设置实地回访频率(0 每月，1 三个月  2  六个月 默认为 1 )
     *
     * @param siteVisitsrate 实地回访频率(0 每月，1 三个月  2  六个月 默认为 1 )
     */
    public void setSiteVisitsrate(Integer siteVisitsrate) {
        this.siteVisitsrate = siteVisitsrate;
    }

    /**
     * 获取电话催收频率(0 每天 1 每周  2 每月)
     *
     * @return PHONE_COLLECTION_RATE - 电话催收频率(0 每天 1 每周  2 每月)
     */
    public Integer getPhoneCollectionRate() {
        return phoneCollectionRate;
    }

    /**
     * 设置电话催收频率(0 每天 1 每周  2 每月)
     *
     * @param phoneCollectionRate 电话催收频率(0 每天 1 每周  2 每月)
     */
    public void setPhoneCollectionRate(Integer phoneCollectionRate) {
        this.phoneCollectionRate = phoneCollectionRate;
    }

    /**
     * 获取上门催收频率(0 每天 1 每周  2 每月 )
     *
     * @return HOME_COLLECTION_RATE - 上门催收频率(0 每天 1 每周  2 每月 )
     */
    public Integer getHomeCollectionRate() {
        return homeCollectionRate;
    }

    /**
     * 设置上门催收频率(0 每天 1 每周  2 每月 )
     *
     * @param homeCollectionRate 上门催收频率(0 每天 1 每周  2 每月 )
     */
    public void setHomeCollectionRate(Integer homeCollectionRate) {
        this.homeCollectionRate = homeCollectionRate;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}