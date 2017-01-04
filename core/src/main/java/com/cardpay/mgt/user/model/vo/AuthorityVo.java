package com.cardpay.mgt.user.model.vo;

import com.cardpay.mgt.user.model.Authority;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * 角色更新Vo
 *
 * @author rankai
 *         createTime 2017-01-2017/1/4 11:10
 */
public class AuthorityVo {

    /**
     * 权限id
     */
    private Integer id;
    /**
     * 权限中文名称
     */
    private String authorityNameZh;

    /**
     * 是否选中
     */
    private boolean selected;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorityNameZh() {
        return authorityNameZh;
    }

    public void setAuthorityNameZh(String authorityNameZh) {
        this.authorityNameZh = authorityNameZh;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
