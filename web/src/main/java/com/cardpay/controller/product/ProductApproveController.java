package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.ErrorMessageUtil;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.ProductApprove;
import com.cardpay.mgt.product.service.ProductApproveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 产品审批流程Controller
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Controller
@RequestMapping("/api/productApprove")
@Api(value = "/api/productApprove", description = "产品审批流程")
public class ProductApproveController extends BaseController<ProductApprove> {

    @Autowired
    private ProductApproveService productApproveService;

    /**
     * 获取产品审批数据分页列表
     *
     * @return 产品审批数据分页列表
     */
    @RequestMapping("/pageList")
    @ApiOperation(value = "产品审批数据列表")
    public DataTablePage pageList() {
        return dataTablePage();
    }

    /**
     * 增加或编辑产品审批页面数据
     *
     * @param productId 产品ID
     * @return 增加或编辑产品审批页面数据
     */
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    @ApiOperation(value = "增加或编辑产品审批页面数据", httpMethod = "GET")
    public ResultTo approve(@PathVariable("productId") Integer productId,
                            @RequestParam(value = "approveId", required = false) Integer approveId) {
        return new ResultTo().setData(productApproveService.getApprove(productId, approveId));
    }

    /**
     * 增加产品审批
     *
     * @param productApprove ProductApprove实体对象
     * @param productError   BindingResult
     * @return 产品ID
     */
    @PostMapping()
    @ApiOperation(value = "增加产品审批", httpMethod = "POST")
    public ResultTo add(ProductApprove productApprove, BindingResult productError) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, productError)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        productApproveService.addApprove(productApprove);
        return new ResultTo().setData(productApprove.getProductId());
    }

    /**
     * 增加产品审批
     *
     * @param productApprove ProductApprove实体对象
     * @param productError   BindingResult
     * @return 产品ID
     */
    @PostMapping()
    @ApiOperation(value = "增加产品审批", httpMethod = "POST")
    public ResultTo update(ProductApprove productApprove, BindingResult productError) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, productError)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        productApproveService.updateApprove(productApprove);
        return new ResultTo().setData(productApprove.getProductId());
    }

}
