package com.cardpay.mgt.product.model.vo;

import com.cardpay.basic.util.treeutil.annotation.TreeChild;
import com.cardpay.basic.util.treeutil.annotation.TreeId;
import com.cardpay.basic.util.treeutil.annotation.TreeParentId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;
import java.util.List;

/**
 * 产品机构Po类
 * Created by chenkai on 2016/12/12.
 */
@ApiModel(value = "产品机构Po类")
public class TProductOrganizationVo {

    @TreeId
    @ApiModelProperty(value = "机构Id", required = true)
    private Integer organizationId;

    @ApiModelProperty(value = "产品Id", required = true)
    private Integer productId;

    @ApiModelProperty(value = "机构名称", required = true)
    private String orgName;

    @ApiModelProperty(value = "父机构id", required = true)
    @TreeParentId
    private Integer orgParentId;

    @TreeChild
    @Transient
    @ApiModelProperty(value = "子机构信息", required = true)
    private List<TProductOrganizationVo> organizationList;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrgParentId() {
        return orgParentId;
    }

    public void setOrgParentId(Integer orgParentId) {
        this.orgParentId = orgParentId;
    }

    public List<TProductOrganizationVo> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<TProductOrganizationVo> organizationList) {
        this.organizationList = organizationList;
    }
}
