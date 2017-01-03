package com.cardpay.mgt.product.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.mgt.product.dao.ProductOrganizationMapper;
import com.cardpay.mgt.product.model.ProductOrganization;
import com.cardpay.mgt.product.model.vo.ProductOrganizationVo;
import com.cardpay.mgt.product.service.ProductOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 产品机构关联服务层实现
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Service
public class ProductOrganizationServiceImpl extends BaseServiceImpl<ProductOrganization> implements ProductOrganizationService {

}
