package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.ProductInvestPictureDesc;
import com.cardpay.mgt.product.service.ProductInvestPictureDescService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品对应调查图片图片说明Controller
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Controller
@RequestMapping("/productPicture")
@Api(value = "/productPicture", description = "产品调查图片")
public class ProductInvestPictureDescController extends BaseController<ProductInvestPictureDesc> {
    @Autowired //产品调查图片Service
    private ProductInvestPictureDescService productInvestPictureDescService;
}
