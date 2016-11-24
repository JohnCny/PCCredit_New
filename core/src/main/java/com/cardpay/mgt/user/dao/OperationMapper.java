package com.cardpay.mgt.user.dao;

import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.Operation;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OperationMapper extends Mapper<Operation> {
    List<Operation> selectByIdList(List<AuthorityResources> authorityResourceses);
}