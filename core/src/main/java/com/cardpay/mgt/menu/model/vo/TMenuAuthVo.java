package com.cardpay.mgt.menu.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.basic.util.treeutil.Tree;
import com.cardpay.mgt.menu.model.MenuAuth;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 菜单Vo类
 * @author yanwe 2016年11月23日17:11:56
 */
@Table(name = "T_MENU")
@ApiModel(value = "菜单")
public class TMenuAuthVo extends GenericEntity<Integer> implements Tree<Integer,TMenuAuthVo>{

    /**
     * 菜单id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select MENU_SEQ.nextval from dual")
    @ApiModelProperty(value = "菜单id", required = true)
    private Integer id;

    /**
     * 菜单名称
     */
    @Column(name = "MENU_NAME_ZH")
    @ApiModelProperty(value = "菜单id", required = true)
    private String menuNameZh;

    /**
     * 菜单中文名称
     */
    @Column(name = "MENU_NAME")
    @ApiModelProperty(value = "菜单名称", required = true)
    private String menuName;

    /**
     * 父菜单id
     */
    @Column(name = "MENU_PARENT_ID")
    @ApiModelProperty(value = "父菜单id", required = true)
    private Integer menuParentId;

    /**
     * 菜单图片url
     */
    @Column(name = "MENU_PICTURE")
    @ApiModelProperty(value = "菜单图片url", required = true)
    private String menuPicture;

    /**
     * 菜单链接url
     */
    @Column(name = "MENU_URL")
    @ApiModelProperty(value = "菜单链接url", required = true)
    private String menuUrl;

    /**
     * 菜单功能描述
     */
    @Column(name = "MENU_DESCRIPTION")
    @ApiModelProperty(value = "菜单功能描述", required = true)
    private String menuDescription;

    /**
     * 统一父菜单下的菜单排列次序
     */
    @Column(name = "MENU_ORDER")
    @ApiModelProperty(value = "统一父菜单下的菜单排列次序", required = true)
    private Integer menuOrder;

    /**
     * 创建用户id
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value = "创建用户id", required = true)
    private Integer createBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    /**
     * 子菜单
     */
    @ApiModelProperty(value = "子菜单", required = true)
    private List<TMenuAuthVo> menuLists;

    /**
     * 权限列表
     */
    @ApiModelProperty(value = "权限列表", required = true)
    private List<MenuAuth> authList;

    @Override
    public Integer getParentId() {
        return menuParentId;
    }

    @Override
    public void setChild(List<TMenuAuthVo> child) {
        setMenuLists(child);
    }

    /**
     * 获取权限列表
     *
     * @return 权限列表
     */
    public List<MenuAuth> getAuthList() {
        return authList;
    }

    /**
     * 设置权限列表
     *
     * @param authList 权限列表
     */
    public void setAuthList(List<MenuAuth> authList) {
        this.authList = authList;
    }

    /**
     * 获取子菜单
     *
     * @return 子菜单
     */
    public List<TMenuAuthVo> getMenuLists() {
        return menuLists;
    }

    /**
     * 设置子菜单
     *
     * @param menuLists 子菜单
     */
    public void setMenuLists(List<TMenuAuthVo> menuLists) {
        this.menuLists = menuLists;
    }

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
     * 获取菜单名称
     *
     * @return MENU_NAME_ZH - 菜单名称
     */
    public String getMenuNameZh() {
        return menuNameZh;
    }

    /**
     * 设置菜单名称
     *
     * @param menuNameZh 菜单名称
     */
    public void setMenuNameZh(String menuNameZh) {
        this.menuNameZh = menuNameZh;
    }

    /**
     * 获取菜单中文名称
     *
     * @return MENU_NAME - 菜单中文名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单中文名称
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
    public Integer getPK() {
        return id;
    }
}