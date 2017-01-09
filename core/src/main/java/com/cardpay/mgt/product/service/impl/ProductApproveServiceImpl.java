package com.cardpay.mgt.product.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.mgt.product.dao.ProductApproveMapper;
import com.cardpay.mgt.product.model.ProductApprove;
import com.cardpay.mgt.product.service.ProductApproveService;
import com.cardpay.mgt.user.dao.RoleMapper;
import com.cardpay.mgt.user.model.Role;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 产品审批流程服务层实现
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Service
public class ProductApproveServiceImpl extends BaseServiceImpl<ProductApprove> implements ProductApproveService {

    @Autowired
    private ProductApproveMapper productApproveMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Map<String, Object> getApprove(Integer productId, Integer approveId) {
        List<Role> roles = roleMapper.select(Role.RoleBuilder.get().withRoleStatus(1).build());
        ProductApprove.ProductApproveBuilder productApproveBuilder = ProductApprove
                .ProductApproveBuilder.get().withProductId(productId);
        Map<String, Object> map = new HashedMap();
        if (approveId == null) {
            List<ProductApprove> selectApprove = productApproveMapper.select(productApproveBuilder.build());
            boolean haveStart = Boolean.TRUE;
            boolean haveNext = Boolean.FALSE;
            for (ProductApprove productApprove : selectApprove) {
                if (productApprove.getNodeType() == 0) {
                    haveStart = Boolean.FALSE;
                    continue;
                }
                if (productApprove.getNodeType() == 2) {
                    haveNext = Boolean.TRUE;
                }
            }
            map.put("haveStart", haveStart);
            map.put("haveNext", haveNext);
        } else {
            ProductApprove productApprove = productApproveMapper.selectByPrimaryKey(approveId);
            map.put("productApprove", productApprove);
        }
        map.put("productId", productId);
        map.put("roles", roles);
        return map;
    }

    @Override
    public void addApprove(ProductApprove productApprove) {
        LogTemplate.info(this.getClass(), "nodeType", productApprove.getNodeType());
        LogTemplate.info(this.getClass(), "preNodeId", productApprove.getPreNodeId());
        if (productApprove.getNodeType() == 0) {
            productApprove.setPreNodeId(-1);
            productApproveMapper.insertSelective(productApprove);
        }
        if (productApprove.getNodeType() == 1) {
            ProductApprove preOneProductApprove = productApproveMapper.selectByPrimaryKey(productApprove.getPreNodeId());

            if (preOneProductApprove.getNextNodeId() != null) {
                Integer nextNodeId = preOneProductApprove.getNextNodeId();
                ProductApprove approve = productApproveMapper.selectByPrimaryKey(nextNodeId);
                if (approve != null) {
                    productApprove.setNextNodeId(preOneProductApprove.getNextNodeId());
                } else {
                    productApprove.setNextNodeId(0);
                }
            } else {
                productApprove.setNextNodeId(0);
            }
            productApproveMapper.insertSelective(productApprove);

            if (preOneProductApprove.getNextNodeId() != null) {
                ProductApprove nextOneProductApprove = productApproveMapper.selectByPrimaryKey(preOneProductApprove.getNextNodeId());
                if (nextOneProductApprove != null) {
                    nextOneProductApprove.setPreNodeId(productApprove.getId());
                    productApproveMapper.updateByPrimaryKeySelective(nextOneProductApprove);
                }
            }

            preOneProductApprove.setNextNodeId(productApprove.getId());
            productApproveMapper.updateByPrimaryKeySelective(preOneProductApprove);
        }
        if (productApprove.getNodeType() == 2) {
            ProductApprove approve = productApproveMapper
                    .selectOne(ProductApprove.ProductApproveBuilder.get().withNextNodeId(0).build());

            productApprove.setPreNodeId(approve.getId());
            productApprove.setNextNodeId(-1);
            productApproveMapper.insertSelective(productApprove);
            approve.setNextNodeId(productApprove.getId());
            productApproveMapper.updateByPrimaryKeySelective(approve);
        }
    }
}
