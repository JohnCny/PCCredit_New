package com.cardpay.mgt.user.dao;

import com.cardpay.mgt.user.model.AuthorityOperation;
import com.cardpay.mgt.user.model.Resources;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResourcesMapper extends Mapper<Resources> {
    List<Resources> selectByIdList(List<AuthorityOperation> authorityOperations);
}