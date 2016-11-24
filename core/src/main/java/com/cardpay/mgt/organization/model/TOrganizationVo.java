package com.cardpay.mgt.organization.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 机构表VO类
 * Created by chenkai on 2016/11/23.
 */
@ApiModel(value = "机构表VO类")
public class TOrganizationVo extends TOrganization{
    /**
     * 子机构列表
     */
    @ApiModelProperty(value = "子机构列表", required = true)
    private List<TOrganization> organizationList;

    public List<TOrganization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<TOrganization> organizationList) {
        this.organizationList = organizationList;
    }
}
