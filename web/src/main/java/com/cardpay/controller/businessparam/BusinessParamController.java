package com.cardpay.controller.businessparam;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.param.model.po.TBusinessParam;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 参数controller
 * @author yanweichen
 */
@Api(value = "/businessparam", description = "参数")
@RestController
@RequestMapping("/businessparam")
public class BusinessParamController extends BaseController<TBusinessParam> {
}
