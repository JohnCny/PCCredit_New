package com.cardpay.mgt.menu.model;

import com.cardpay.basic.base.model.GenericEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

/**
 * 菜单PO类
 *
 * @author yanwe 2016年11月23日17:11:56
 */
@Table(name = "T_MENU")
public class TMenu extends GenericEntity<Integer>{
    /**
     * 菜单id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select MENU_SEQ.nextval from dual")
    private Integer id;

    /**
     * 菜单中文名称
     */
    @Column(name = "MENU_NAME_ZH")
    private String menuNameZh;

    /**
     * 菜单名称
     */
    @Column(name = "MENU_NAME")
    private String menuName;

    /**
     * 父菜单id
     */
    @Column(name = "MENU_PARENT_ID")
    private Integer menuParentId;

    /**
     * 菜单图片url
     */
    @Column(name = "MENU_PICTURE")
    private String menuPicture;

    /**
     * 菜单链接url
     */
    @Column(name = "MENU_URL")
    private String menuUrl;

    /**
     * 菜单功能描述
     */
    @Column(name = "MENU_DESCRIPTION")
    private String menuDescription;

    /**
     * 统一父菜单下的菜单排列次序
     */
    @Column(name = "MENU_ORDER")
    private Integer menuOrder;

    /**
     * 创建用户id
     */
    @Column(name = "CREATE_BY")
    private Integer createBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 获取菜单id
     *
     * @return ID - 菜单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置菜单id
     *
     * @param id 菜单id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单中文名称
     *
     * @return MENU_NAME_ZH - 菜单名称
     */
    public String getMenuNameZh() {
        return menuNameZh;
    }

    /**
     * 设置菜单中文名称
     *
     * @param menuNameZh 菜单名称
     */
    public void setMenuNameZh(String menuNameZh) {
        this.menuNameZh = menuNameZh;
    }

    /**
     * 获取菜单名称
     *
     * @return MENU_NAME - 菜单中文名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单中文名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取父菜单id
     *
     * @return MENU_PARENT_ID - 父菜单id
     */
    public Integer getMenuParentId() {
        return menuParentId;
    }

    /**
     * 设置父菜单id
     *
     * @param menuParentId 父菜单id
     */
    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    /**
     * 获取菜单图片url
     *
     * @return MENU_PICTURE - 菜单图片url
     */
    public String getMenuPicture() {
        return menuPicture;
    }

    /**
     * 设置菜单图片url
     *
     * @param menuPicture 菜单图片url
     */
    public void setMenuPicture(String menuPicture) {
        this.menuPicture = menuPicture;
    }

    /**
     * 获取菜单链接url
     *
     * @return MENU_URL - 菜单链接url
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置菜单链接url
     *
     * @param menuUrl 菜单链接url
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * 获取菜单功能描述
     *
     * @return MENU_DESCRIPTION - 菜单功能描述
     */
    public String getMenuDescription() {
        return menuDescription;
    }

    /**
     * 设置菜单功能描述
     *
     * @param menuDescription 菜单功能描述
     */
    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    /**
     * 获取统一父菜单下的菜单排列次序
     *
     * @return MENU_ORDER - 统一父菜单下的菜单排列次序
     */
    public Integer getMenuOrder() {
        return menuOrder;
    }

    /**
     * 设置统一父菜单下的菜单排列次序
     *
     * @param menuOrder 统一父菜单下的菜单排列次序
     */
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * 获取创建用户id
     *
     * @return CREATE_BY - 创建用户id
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建用户id
     *
     * @param createBy 创建用户id
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TMenu{" +
                "id=" + id +
                ", menuNameZh='" + menuNameZh + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuParentId=" + menuParentId +
                ", menuPicture='" + menuPicture + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuDescription='" + menuDescription + '\'' +
                ", menuOrder=" + menuOrder +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                '}';
    }

    @Override
    public Integer getPK() {
        return id;
    }
}