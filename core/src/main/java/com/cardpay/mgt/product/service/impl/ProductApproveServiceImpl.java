package com.cardpay.mgt.product.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.shiro.common.ShiroKit;
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
        List<Role> roles = roleMapper.select(Role.RoleBuilder.get()
                .withOrganizationId(ShiroKit.getOrgId()).withRoleStatus(1).build());
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
            map.put("haveStart", haveStart);//是否有开始节点
            map.put("haveNext", haveNext);//是否有结束节点
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
        //开始节点
        if (productApprove.getNodeType() == 0) {
            productApprove.setPreNodeId(-1);
            productApproveMapper.insertSelective(productApprove);
        }
        //中间节点
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
        //结束节点
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

    @Override
    public void updateApprove(ProductApprove productApprove) {
        LogTemplate.debug(this.getClass(), "productApprove", productApprove);
        ProductApprove oldApprove = productApproveMapper.selectByPrimaryKey(productApprove.getId());
        productApprove.setProductId(oldApprove.getId());
        if (oldApprove.getNodeType() != 0 && oldApprove.getNodeType() != 2) {
            if (!oldApprove.getPreNodeId().equals(productApprove.getPreNodeId())) {
                //新增位置
                ProductApprove newApprovePreNode = productApproveMapper.selectByPrimaryKey(productApprove.getPreNodeId());
                ProductApprove newApproveNextNode = productApproveMapper.selectByPrimaryKey(newApprovePreNode.getNextNodeId());
                productApprove.setNextNodeId(newApprovePreNode.getNextNodeId());
                newApprovePreNode.setNextNodeId(productApprove.getId());
                productApproveMapper.updateByPrimaryKeySelective(newApprovePreNode);
                newApproveNextNode.setPreNodeId(productApprove.getId());
                productApproveMapper.updateByPrimaryKeySelective(newApproveNextNode);

                //原位置
                ProductApprove oldApprovePreNode = productApproveMapper.selectByPrimaryKey(oldApprove.getPreNodeId());
                ProductApprove oldApproveNextNode = productApproveMapper.selectByPrimaryKey(oldApprove.getNextNodeId());
                oldApprovePreNode.setNextNodeId(oldApproveNextNode.getId());
                productApproveMapper.updateByPrimaryKeySelective(oldApprovePreNode);
                oldApproveNextNode.setPreNodeId(oldApprovePreNode.getId());
                productApproveMapper.updateByPrimaryKeySelective(oldApproveNextNode);
            }
        }
        productApproveMapper.updateByPrimaryKeySelective(productApprove);
    }

    @Override
    public List<ProductApprove> selectAllByProductId(Integer productId) {
        ProductApprove productApprove = new ProductApprove();
        productApprove.setProductId(productId);
        List<ProductApprove> productApproves = productApproveMapper.select(productApprove);
        for (ProductApprove _productApprove : productApproves) {
            if (_productApprove.getNextNodeId() == -1) {
                productApproves.remove(_productApprove);
                break;
            }
        }
        return productApproves;
    }

    @Override
    public boolean deleteApprove(Integer approveId) {
        return false;
    }
}
