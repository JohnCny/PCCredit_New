package com.cardpay.mgt.application.ipc.basic.model;

import com.cardpay.basic.util.treeutil.annotation.TreeChild;
import com.cardpay.basic.util.treeutil.annotation.TreeId;
import com.cardpay.basic.util.treeutil.annotation.TreeParentId;

import java.util.List;

/**
 * IPC菜单
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/11 16:40
 */
public class IPCMenu {

    /**
     * 菜单Id
     */
    @TreeId
    private Integer menuId;

    /**
     * 菜单父Id
     */
    @TreeParentId
    private Integer menuParentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单顺序
     */
    private Integer menuOrder;

    /**
     * 菜单对应模板ID
     */
    private Integer templateId;

    /**
     * 模板类型
     */
    private Integer templateType;

    /**
     * 菜单链接
     */
    private String menuURL;

    /**
     * 子菜单
     */
    @TreeChild
    private List<IPCMenu> menuLists;

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuURL() {
        return menuURL;
    }

    public void setMenuURL(String menuURL) {
        this.menuURL = menuURL;
    }

    public List<IPCMenu> getMenuLists() {
        return menuLists;
    }

    public void setMenuLists(List<IPCMenu> menuLists) {
        this.menuLists = menuLists;
    }
}
