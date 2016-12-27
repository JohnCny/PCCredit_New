package com.cardpay.mgt.customer.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Lazy;


/**
 * 客户维护信息Vo
 * @author chenkai 2016/12/22 13:30
 */
@Lazy
@ApiModel(value = "客户维护信息Vo")
public class TCustomerMaintenanceVo extends GenericEntity<Integer> {
    /**
     * 客户id
     */
    @ApiModelProperty(value = "客户id", required = true)
    private Integer id;

    /**
     *证件号码
     */
    @ApiModelProperty(value = "证件号码", required = true)
    private String certificateNumber;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式", required = true)
    private String tel;

    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称", required = true)
    private String cname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}
