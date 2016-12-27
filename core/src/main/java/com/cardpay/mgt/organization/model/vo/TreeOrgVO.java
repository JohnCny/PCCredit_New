package com.cardpay.mgt.organization.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import org.springframework.context.annotation.Lazy;

/**
 * zTree专用VO
 *
 * @author rankai
 *         createTime 2016-12-2016/12/24 14:42
 */
@Lazy
@ApiModel(value = "zTree专用VO")
public class TreeOrgVO extends GenericEntity<Integer> {

    private Integer id;

    private String name;

    private Integer pId;

    private boolean open = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}
