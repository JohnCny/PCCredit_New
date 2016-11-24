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
     * 子机构
     */
    @ApiModelProperty(value = "子机构", required = true)
    private List<TOrganization> list;

    public List<TOrganization> getList() {
        return list;
    }

    public void setList(List<TOrganization> list) {
        this.list = list;
    }
}
