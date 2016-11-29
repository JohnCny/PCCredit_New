package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.AuthorityOperation;
import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.Resources;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 资源Da层接口
 *
 * @author rankai
 */
public interface ResourcesMapper extends BasicMapper<Resources> {
    /**
     * 根据权限资源关系集合获取资源集合
     * @param authorityResources 权限资源关系集合
     * @return 资源集合
     */
    List<Resources> selectByIdList(List<AuthorityResources> authorityResources);
}