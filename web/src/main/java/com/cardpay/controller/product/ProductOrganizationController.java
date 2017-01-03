package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.ProductOrganization;
import com.cardpay.mgt.product.model.vo.ProductOrganizationVo;
import com.cardpay.mgt.product.service.ProductOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品机构关联Controller
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Controller
@RequestMapping("/productOrganization")
@Api(value = "/productOrganization", description = "产品机构关联")
public class ProductOrganizationController extends BaseController<ProductOrganization> {
    @Autowired
    private ProductOrganizationService productOrganizationService;

    /**
     * 产品机构信息封装Map
     *
     * @param productId 产品id
     * @param orgIds    机构id集合
     * @return map集合
     */
    private Map<String, Object> productOrgMap(int productId, String orgIds) {
        List<String> orgIdList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        String[] id = orgIds.split(",");
        for (String orgId : id) {
            orgIdList.add(orgId);
        }
        map.put("productId", productId);
        map.put("orgIds", orgIdList);
        return map;
    }

    /**
     * 批量添加产品机构信息接口
     *
     * @param productId 产品id
     * @param orgIds    机构id
     * @return 新增产品信息id集合
     */
    @ResponseBody
    @PostMapping
    @ApiOperation(value = "批量添加产品机构信息接口", notes = "添加产品机构信息", httpMethod = "POST")
    public ResultTo insertProductOrganization(@ApiParam(value = "产品id", required = true) @RequestParam int productId
            , @ApiParam(value = "机构id(','分割)", required = true) @RequestParam String orgIds) {
        List<ProductOrganization> productOrganizationList = new ArrayList<>();
        Integer flag = productOrganizationService.batchInsertOrg(productOrgMap(productId, orgIds));
        if (null != flag) {
            ProductOrganization productOrganization = new ProductOrganization();
            productOrganization.setProductId(productId);
            productOrganizationList = productOrganizationService.select(productOrganization);
        }
        return new ResultTo().setData(productOrganizationList);
    }

    /**
     * 批量删除产品机构信息接口
     *
     * @param productId 产品id
     * @param orgIds    机构id
     * @return 数据库变动条数
     */
    @ResponseBody
    @DeleteMapping
    @ApiOperation(value = "批量删除产品机构信息接口", notes = "删除产品机构信息", httpMethod = "DELETE")
    public ResultTo deleteProductOrganization(@ApiParam(value = "产品id", required = true) @RequestParam int productId
            , @ApiParam(value = "机构id(','分割)", required = true) @RequestParam String orgIds) {
        int count = productOrganizationService.bathDeleteOrg(productOrgMap(productId, orgIds));
        return new ResultTo().setData(count);
    }

    /**
     * 查询产品关联机构信息
     *
     * @param productId 产品id
     * @param topId     顶级id
     * @return 产品关联机构信息
     */
    @ResponseBody
    @GetMapping
    @ApiOperation(value = "查询产品关联机构信息", notes = "删除产品机构信息", httpMethod = "GET")
    public ResultTo queryProductOrganization(@ApiParam(value = "产品id", required = true) @RequestParam int productId
            , @ApiParam(value = "顶级ID(默认最高级开始)") @RequestParam(defaultValue = "0") int topId) {
        List<ProductOrganizationVo> productOrganizationPoList = productOrganizationService.queryProductOrg(productId, topId);
        return new ResultTo().setData(productOrganizationPoList);
    }

}
