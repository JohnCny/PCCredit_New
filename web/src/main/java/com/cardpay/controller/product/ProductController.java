package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.ErrorMessageUtil;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.mgt.product.model.*;
import com.cardpay.mgt.product.model.vo.ExplainList;
import com.cardpay.mgt.product.service.*;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.util.*;


/**
 * 产品管理Controller
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
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
    private ProductApproveService productApproveService;

    @Autowired
    private ProductLoanMonitorRulesService productLoanMonitorRulesService;

    @Autowired
    private ProductRiskRulesService productRiskRulesService;

    /**
     * 获取产品分页数据
     *
     * @return 产品分页数据
     */
    @GetMapping("/pageList")
    @ApiOperation(value = "产品分页数据", httpMethod = "GET")
    public DataTablePage pageList() {
        return dataTablePage();
    }

    /**
     * 获取增加产品信息页面数据
     *
     * @return 增加产品信息页面数据
     */
    @GetMapping("/information")
    @ApiOperation(value = "增加产品信息页面数据", httpMethod = "GET")
    public ResultTo information() {
        List<ProductType> productTypes = productTypeService.selectAll();
        Map<String, Object> map = new HashedMap();
        map.put("productTypes", productTypes);
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
    @PostMapping("/information")
    @ApiOperation(value = "增加产品信息", httpMethod = "POST")
    public ResultTo information(Product product, BindingResult productError, MultipartFile productImg,
                                String orgStr, ExplainList explainList) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, productError)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        Integer productId = productService.addProduct(product, productImg, orgStr, explainList);
        return new ResultTo().setData(productId);
    }


    @RequestMapping(value = "/{productId}/approve", method = RequestMethod.GET)
    @ApiOperation(value = "增加产品审批页面数据", httpMethod = "GET")
    public ResultTo approve(@PathVariable("productId") Integer productId) {
        return new ResultTo().setData(productApproveService.getApprove(productId));
    }

    /**
     * 增加产品审批
     *
     * @param productApprove ProductApprove实体对象
     * @param productError   BindingResult
     * @param productId      产品ID
     * @return 产品ID
     */
    @PostMapping("/approve")
    @ApiOperation(value = "增加产品审批", httpMethod = "POST")
    public ResultTo approve(ProductApprove productApprove, BindingResult productError, Integer productId) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, productError)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        productApproveService.addApprove(productApprove, productId);
        return new ResultTo().setData(productId);
    }

    /**
     * 增加产品贷后页面数据
     *
     * @param productId 产品ID
     * @return 产品贷后页面数据
     */
    @RequestMapping(value = "/{productId}/loan", method = RequestMethod.GET)
    @ApiOperation(value = "增加产品贷后页面数据", httpMethod = "GET")
    public ResultTo loan(@PathVariable("productId") Integer productId) {
        return new ResultTo();
    }

    /**
     * 增加产品贷后
     *
     * @param productLoanMonitorRules ProductLoanMonitorRules实体对象
     * @param result                  BindingResult
     * @param productId               产品ID
     * @return 成功或失败
     */
    @PostMapping(value = "/loan")
    @ApiOperation(value = "增加产品贷后", httpMethod = "POST")
    public ResultTo loan(ProductLoanMonitorRules productLoanMonitorRules, BindingResult result,
                         @RequestParam("productId") Integer productId) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        productLoanMonitorRules.setProductId(productId);
        productLoanMonitorRulesService.insertSelective(productLoanMonitorRules);
        return new ResultTo();
    }

    /**
     * 增加产品风险控制规则
     *
     * @param productRiskRules ProductRiskRules
     * @param result           BindingResult
     * @param productId        产品ID
     * @return 成功或失败
     */
    @PostMapping(value = "/risk")
    @ApiOperation(value = "增加产品贷后", httpMethod = "POST")
    public ResultTo risk(ProductRiskRules productRiskRules, BindingResult result,
                         @RequestParam("productId") Integer productId) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        productRiskRules.setProductId(productId);
        productRiskRulesService.insertSelective(productRiskRules);
        Product product = productService.selectByPrimaryKey(productId);
        product.setProductState(1);
        productService.updateSelectiveByPrimaryKey(product);
        return new ResultTo();
    }


}
