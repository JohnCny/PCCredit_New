package com.cardpay.mgt.product.model.po;

import com.cardpay.basic.util.treeutil.Tree;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 产品机构Po类
 * Created by chenkai on 2016/12/12.
 */
@ApiModel(value = "产品机构Po类")
public class ProductOrganzationPo implements Tree<Integer, ProductOrganzationPo>{

    @ApiModelProperty(value = "产品Id", required = true)
    private Integer productId;

    @ApiModelProperty(value = "机构Id", required = true)
    private Integer oraganizationId;

    @ApiModelProperty(value = "机构名称", required = true)
    private String orgName;

    @ApiModelProperty(value = "父机构id", required = true)
    private Integer orgParentId;

    @Override
    public Integer getId() {
        return productId;
    }

    @Override
    public Integer getParentId() {
        return orgParentId;
    }

    @Override
    public void setChild(List<ProductOrganzationPo> child) {

    }
}
