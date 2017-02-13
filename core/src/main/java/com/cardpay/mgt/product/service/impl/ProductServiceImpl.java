package com.cardpay.mgt.product.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.product.dao.ProductDescMapper;
import com.cardpay.mgt.product.dao.ProductMapper;
import com.cardpay.mgt.product.dao.ProductOrgMapper;
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
import java.util.List;

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
    private ProductOrgMapper productOrgMapper;

    @Autowired
    private ProductDescMapper productDescMapper;

    @Override
    @Transactional
    public Integer addProduct(Product product, MultipartFile productImg, String orgStr, ExplainList explainList) {
        product.setCreateBy(ShiroKit.getUserId());
        product.setCreateTime(new Date());
        product.setProductState(2);//状态:创建中
        product.setOrganizationId(ShiroKit.getOrgId());
        if (productImg != null) {
            product.setProductPictureUrl(fileManager.upLoadExt(productImg));
        }
        int productCount = productMapper.insertSelective(product);
        if (productCount > 0) {
            String[] orgIds = orgStr.split(",");
            productOrgMapper.batchInsertOrg(product.getId(), orgIds);
        }
        if (explainList != null && explainList.getExplainList() != null) {
            for (ProductInvestPictureDesc productInvestPictureDesc : explainList.getExplainList()) {
                productInvestPictureDesc.setProductId(product.getId());
                productDescMapper.insertSelective(productInvestPictureDesc);
            }
        }
        return product.getId();
    }

    @Override
    public boolean updateProduct(Product product, MultipartFile productImg, String orgStr, ExplainList explainList) {
        LogTemplate.debug(this.getClass(), "product", product);
        LogTemplate.debug(this.getClass(), "orgStr", orgStr);
        if (productImg != null) {
            Product productOne = productMapper.selectByPrimaryKey(product.getId());
            String[] split = productOne.getProductPictureUrl().split(",");
            fileManager.deleteFile(split[0], split[1]);
            product.setProductPictureUrl(fileManager.upLoadExt(productImg));
        }
        if (orgStr != null && orgStr.length() > 0) {
            ProductOrganization productOrganization = new ProductOrganization();
            productOrganization.setProductId(product.getId());
            productOrgMapper.delete(productOrganization);
            String[] orgIds = orgStr.split(",");
            productOrgMapper.batchInsertOrg(product.getId(), orgIds);
        }
        if (explainList != null && explainList.getExplainList() != null) {
            for (ProductInvestPictureDesc productInvestPictureDesc : explainList.getExplainList()) {
                if (productInvestPictureDesc.getId() == null) {
                    productInvestPictureDesc.setProductId(product.getId());
                    productDescMapper.insertSelective(productInvestPictureDesc);
                    continue;
                }
                productDescMapper.updateByPrimaryKeySelective(productInvestPictureDesc);
            }
        }
        return productMapper.updateByPrimaryKeySelective(product) > 0;
    }
}
