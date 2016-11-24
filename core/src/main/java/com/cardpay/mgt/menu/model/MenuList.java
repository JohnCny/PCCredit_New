package com.cardpay.mgt.menu.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "MENU")
public class MenuList {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Short id;

    @Column(name = "MENU_NAME")
    private String menuName;

    @Column(name = "PARENT_ID")
    private Short parentId;

    @Column(name = "MENU_LEVEL")
    private Short menuLevel;

    /**
     * 子菜单
     */
    @Transient
    private List<MenuList> menuLists;

    public List<MenuList> getMenuLists() {
        return menuLists;
    }

    public void setMenuLists(List<MenuList> menuLists) {
        this.menuLists = menuLists;
    }

    /**
     * @return ID
     */
    public Short getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * @return MENU_NAME
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return PARENT_ID
     */
    public Short getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    /**
     * @return MENU_LEVEL
     */
    public Short getMenuLevel() {
        return menuLevel;
    }

    /**
     * @param menuLevel
     */
    public void setMenuLevel(Short menuLevel) {
        this.menuLevel = menuLevel;
    }
}