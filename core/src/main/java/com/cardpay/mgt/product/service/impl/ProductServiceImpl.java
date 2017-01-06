package com.cardpay.mgt.product.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.product.dao.ProductInvestPictureDescMapper;
import com.cardpay.mgt.product.dao.ProductMapper;
import com.cardpay.mgt.product.dao.ProductOrganizationMapper;
import com.cardpay.mgt.product.model.Product;
import com.cardpay.mgt.product.model.ProductInvestPictureDesc;
import com.cardpay.mgt.product.model.ProductOrganization;
import com.cardpay.mgt.product.model.vo.ExplainList;
import com.cardpay.mgt.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 产品管理服务层实现
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private FileManager fileManager;

    @Autowired
    private ProductOrganizationMapper productOrganizationMapper;

    @Autowired
    private ProductInvestPictureDescMapper productInvestPictureDescMapper;

    @Override
    @Transactional
    public Integer addProduct(Product product, MultipartFile productImg, String orgStr, ExplainList explainList) {
        product.setCreateBy(ShiroKit.getUserId());
        product.setCreateTime(new Date());
        product.setProductState(2);//状态:创建中
        if (productImg != null) {
            product.setProductPictureUrl(fileManager.upLoad(productImg));
        }
        int productCount = productMapper.insertSelective(product);
        if (productCount > 0) {
            String[] split = orgStr.split(",");
            for (String orgId : split) {
                ProductOrganization productOrganization = new ProductOrganization();
                productOrganization.setProductId(product.getId());
                productOrganization.setOraganizationId(Integer.parseInt(orgId));
                productOrganizationMapper.insertSelective(productOrganization);
            }
        }
        if (explainList != null && explainList.getList() != null) {
            for (ProductInvestPictureDesc productInvestPictureDesc : explainList.getList()) {
                productInvestPictureDescMapper.insertSelective(productInvestPictureDesc);
            }
        }
        return product.getId();
    }
}
