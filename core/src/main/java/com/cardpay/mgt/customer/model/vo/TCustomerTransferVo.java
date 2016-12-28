package com.cardpay.mgt.customer.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Lazy;

/**
 * 客户移交Vo
 * @author chenkai 2016/12/22 10:24
 */
@Lazy
@ApiModel(value = "客户移交Vo")
public class TCustomerTransferVo extends GenericEntity<String> {
    /**
     * 客户id
     */
    @ApiModelProperty(value = "客户id", required = true)
    private String id;
    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称", required = true)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPK() {
        return id;
    }
}
