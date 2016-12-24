package com.cardpay.mgt.customer.model.vo;

/**
 * 客户维护信息Vo
 * @author chenkai 2016/12/22 13:30
 */
public class TCustomerMaintenanceVo {
    /**
     * 客户id
     */
    private Integer id;

    /**
     *证件号码
     */
    private String certificateNumber;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 客户名称
     */
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
}
