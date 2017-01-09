package com.cardpay.mgt.product.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.product.model.Product;
import com.cardpay.mgt.product.model.vo.ExplainList;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品管理服务层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface ProductService extends BaseService<Product> {
    /**
     * 增加产品
     *
     * @param product     产品实体
     * @param productImg  产品图片
     * @param orgStr      产品准入机构字符(机构间用','隔开)
     * @param explainList 图片说明集合
     * @return 产品ID
     */
    Integer addProduct(Product product, MultipartFile productImg, String orgStr, ExplainList explainList);


    /**
     * 更新产品信息
     *
     * @param product     产品实体
     * @param productImg  产品图片
     * @param orgStr      产品准入机构字符(机构间用','隔开)
     * @param explainList 图片说明集合
     * @return 产品ID
     */
    boolean update(Product product, MultipartFile productImg, String orgStr, ExplainList explainList);
}
