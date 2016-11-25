package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.AuthorityOperation;
import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.Operation;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OperationMapper extends BasicMapper<Operation> {
    List<Operation> selectByIdList(List<AuthorityOperation> authorityOperation);
}