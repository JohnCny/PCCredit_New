package com.cardpay.controller.business.param;

import com.cardpay.controller.base.BaseController;
import com.cardpay.core.business.param.model.po.TBusinessParam;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 参数controller
 * @author wangpeng
 */
@Api(value = "/businessparam", description = "参数")
@RestController
@RequestMapping("/businessparam")
public class BusinessParamController extends BaseController<TBusinessParam> {
}
