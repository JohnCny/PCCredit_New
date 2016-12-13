package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.TProductInvestPictureDesc;
import com.cardpay.mgt.product.service.TProductInvestPictureDescService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品对应调查图片图片说明
 * Created by chenkai on 2016/12/12.
 */
@RestController
@RequestMapping("/productPicture")
@Api(value = "/productPicture", description = "产品调查图片")
public class ProductInvestPictureDescController extends BaseController<TProductInvestPictureDesc, Integer> {
    @Autowired //产品调查图片Service
    private TProductInvestPictureDescService tProductInvestPictureDescService;
}
