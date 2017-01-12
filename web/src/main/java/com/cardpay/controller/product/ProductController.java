package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.ErrorMessageUtil;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.industry.service.IndustryService;
import com.cardpay.mgt.product.model.*;
import com.cardpay.mgt.product.model.vo.ExplainList;
import com.cardpay.mgt.product.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


/**
 * 产品管理Controller
 *
 * @author rankai
 */
@RestController
@RequestMapping("/api/product")
@Api(value = "/api/product", description = "产品管理")
public class ProductController extends BaseController<Product> {

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductOrgService productOrgService;

    @Autowired
    private ProductDescService productDescService;

    @Autowired
    private IndustryService industryService;

    /**
     * 获取产品分页数据
     *
     * @return 产品分页数据
     */
    @RequestMapping("/pageList")
    @ApiOperation(value = "产品分页数据")
    public DataTablePage pageList() {
        return dataTablePage();
    }

    /**
     * 获取增加产品信息页面数据
     *
     * @return 增加产品信息页面数据
     */
    @GetMapping
    @ApiOperation(value = "增加产品信息页面数据", httpMethod = "GET")
    public ResultTo information(@RequestParam(value = "productId", required = false) Integer productId) {
        Map<String, Object> map = new HashedMap();
        if (productId != null) {
            map.put("product", productService.selectByPrimaryKey(productId));
            map.put("productOrg", productOrgService.selectByPrimaryKey(productId));
            map.put("productDesc", productDescService.selectByPrimaryKey(productId));
        }
        map.put("industry", industryService.selectAll());
        map.put("productTypes", productTypeService.selectAll());
        return new ResultTo().setData(map);
    }

    /**
     * 增加产品
     *
     * @param product      产品实体
     * @param productError BindingResult
     * @param productImg   产品图片
     * @param orgStr       产品准入机构字符(机构间用','隔开)
     * @param explainList  图片说明集合
     * @return 产品ID
     */
    @PostMapping
    @ApiOperation(value = "增加产品信息", httpMethod = "POST")
    public ResultTo add(Product product, BindingResult productError,
                        @RequestParam(value = "productImg", required = false) MultipartFile productImg,
                        String orgStr, ExplainList explainList) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, productError)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        if (StringUtils.isBlank(orgStr) || explainList == null) {
            return new ResultTo(ResultEnum.PARAM_ERROR);
        }
        Integer productId = productService.addProduct(product, productImg, orgStr, explainList);
        return new ResultTo().setData(productId);
    }

    /**
     * 更新产品信息
     *
     * @param product      产品实体
     * @param productError BindingResult
     * @param productImg   产品图片
     * @param orgStr       产品准入机构字符(机构间用','隔开)
     * @param explainList  图片说明集合
     * @return 产品ID
     */
    @PutMapping
    @ApiOperation(value = "更新产品信息", httpMethod = "PUT")
    public ResultTo update(Product product, BindingResult productError, MultipartFile productImg,
                           String orgStr, ExplainList explainList) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, productError)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        if (productService.updateProduct(product, productImg, orgStr, explainList)) {
            return new ResultTo();
        }
        return new ResultTo(ResultEnum.OPERATION_FAILED);
    }


}
