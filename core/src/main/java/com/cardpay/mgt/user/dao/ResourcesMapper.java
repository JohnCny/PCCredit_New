package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.AuthorityOperation;
import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.Resources;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResourcesMapper extends BasicMapper<Resources> {
    List<Resources> selectByIdList(List<AuthorityResources> authorityResources);
}