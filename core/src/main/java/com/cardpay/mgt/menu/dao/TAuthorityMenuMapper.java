package com.cardpay.mgt.menu.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.menu.model.TAuthorityMenu;

import java.util.List;

public interface TAuthorityMenuMapper extends BasicMapper<TAuthorityMenu> {

    /**
     * 批量插入
     *
     * @param list 列表
     * @return 结果
     */
    Integer batchInsert(List<TAuthorityMenu> list);
}