package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.Product;
import com.cardpay.mgt.product.model.ProductInvestPictureDesc;
import com.cardpay.mgt.product.service.ProductDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 产品对应调查图片图片说明服务Controller
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/22 16:01
 */
@RestController
@RequestMapping("/productDes")
public class ProductDescController extends BaseController<ProductInvestPictureDesc> {
    @Autowired
    private ProductDescService productDescService;

    @GetMapping("/{productId}")
    public ResultTo get(@PathVariable("productId") int productId){
        ProductInvestPictureDesc product = new ProductInvestPictureDesc();
        product.setId(productId);
        List<ProductInvestPictureDesc> investPictureDescList = productDescService.select(product);
        return new ResultTo().setData(investPictureDescList);
    }

}
