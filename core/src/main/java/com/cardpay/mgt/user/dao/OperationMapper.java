package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.AuthorityOperation;
import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.Operation;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 权限资源操作关系Dao层接口
 *
 * @author rankai
 */
public interface OperationMapper extends BasicMapper<Operation> {
    /**
     * 根据权限资源操作关系集合获取资源集合
     *
     * @param authorityOperation 权限资源操作关系集合
     * @return 资源操作集合
     */
    List<Operation> selectByIdList(List<AuthorityOperation> authorityOperation);
}