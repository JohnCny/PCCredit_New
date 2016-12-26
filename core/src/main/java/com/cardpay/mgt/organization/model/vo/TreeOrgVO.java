package com.cardpay.mgt.organization.model.vo;

/**
 * zTree专用VO
 *
 * @author rankai
 *         createTime 2016-12-2016/12/24 14:42
 */
public class TreeOrgVO {

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
}
