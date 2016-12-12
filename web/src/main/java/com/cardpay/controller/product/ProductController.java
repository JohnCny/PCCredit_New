package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.mgt.product.model.*;
import com.cardpay.mgt.product.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * 产品管理Controller
 * Created by chenkai on 2016/12/8.
 */
@RestController
@RequestMapping("/product")
@Api(value = "/product", description = "产品管理Controller类")
public class ProductController extends BaseController<TProduct, Integer> {
    @Autowired //产品Service
    private TProductService tProductService;

    @Autowired //fastDfs Service
    private FileManager fileManager;

    @Autowired //产品机构关联Service
    private TProductOrganizationService tProductOrganizationService;

    @Autowired //产品调查图片Service
    private TProductInvestPictureDescService tProductInvestPictureDescService;

    @Autowired //产品审批流程Service
    private TProductApproveService tProductApproveService;

    @Autowired //产品贷后监控规则Service
    private TProductLoanMonitorRulesService tProductLoanMonitorRulesService;

    @Autowired //产品产品风险规则Service
    private TProductRiskRulesService tProductRiskRulesService;


    @ApiOperation(value = "新增产品信息接口", notes = "添加产品基本信息", httpMethod = "POST")
    @RequestMapping(value = "newProduct", method = RequestMethod.POST)
    public ResultTo insertProduct(@ApiParam(value = "产品信息", required = true) @ModelAttribute TProduct tProduct
            , @ApiParam(value = "图片信息(需要上传)", required = true) @RequestPart MultipartFile file
            , @ApiParam(value = "机构id(','分割)", required = true) @RequestParam String orgIds) {
        Integer flag = batchInsertOrg(tProduct.getId(), orgIds);
        if (null != flag) {
            //上传产品图片
            String upLoadParam = fileManager.upLoad(file);
            String[] split = upLoadParam.split(",");
            tProduct.setProductPictureUrl(split[0] + split[1]);
            tProduct.setCreateTime(new Date());
            tProduct.setModifyTime(new Date());
            tProductService.insert(tProduct);
            //若添加失败则删除fastDfs上的文件
            if (tProduct.getId() == null) {
                FileManager.deleteFile(split[0], split[1]);
            }
            return new ResultTo().setData(tProduct.getId());
        }
        return new ResultTo(ResultEnum.SERVICE_ERROR.getValue());
    }

    /**
     * 批量插入准入客户经理级别以及机构
     *
     * @param productId 产品id
     * @param orgIds    机构id集合
     * @return 影响数据库行数
     */
    private int batchInsertOrg(int productId, String orgIds) {
        List<String> orgIdList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        String[] id = orgIds.split(",");
        for (String orgId : id) {
            orgIdList.add(orgId);
        }
        map.put("productId", productId);
        map.put("orgIds", orgIdList);
        return tProductOrganizationService.batchInsert(map);
    }

    /**
     * 添加产品调查图片信息
     *
     * @param tProductInvestPictureDesc 产品调查图片信息
     * @return 产品调查图片信息id
     */
    @ApiOperation(value = "添加调查图片信息", notes = "添加产品调查图片信息", httpMethod = "POST")
    @RequestMapping(value = "productImgCaption", method = RequestMethod.POST)
    public ResultTo insertProductImgCaption(@ApiParam("产品调查图片信息") @ModelAttribute TProductInvestPictureDesc tProductInvestPictureDesc) {
        Integer flag = tProductInvestPictureDescService.insert(tProductInvestPictureDesc);
        return null != flag ? new ResultTo().setData(tProductInvestPictureDesc.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR.getValue());
    }

    /**
     * 删除产品调查图片信息
     *
     * @param productImgCaptionId 产品调查图片信息id
     * @return 影响数据库行数
     */
    @ApiOperation(value = "删除调查图片信息", notes = "删除产品调查图片信息", httpMethod = "DELETE")
    @RequestMapping(value = "productImgCaption", method = RequestMethod.DELETE)
    public ResultTo deleteProductImgCaption(@ApiParam(value = "产品调查图片信息id") @RequestParam("id") int productImgCaptionId) {
        Integer delete = tProductInvestPictureDescService.delete(new TProductInvestPictureDesc(productImgCaptionId));
        return null != delete ? new ResultTo() : new ResultTo(ResultEnum.SERVICE_ERROR.getValue());
    }

    /**
     * 新增产品审批流程
     *
     * @param tProductApprove 产品审批流程信息
     * @return 产品审批流程id
     */
    @ApiOperation(value = "新增产品审批流程", notes = "新增产品审批流程", httpMethod = "POST")
    @RequestMapping(value = "productApprove", method = RequestMethod.POST)
    public ResultTo productApprove(@ApiParam("产品审批流程") @ModelAttribute TProductApprove tProductApprove) {
        Integer flag = tProductApproveService.insert(tProductApprove);
        return null != flag ? new ResultTo().setData(tProductApprove.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR.getValue());
    }

    /**
     * 新增产品贷后监控规则
     *
     * @param tProductLoanMonitorRules 产品贷后监控规则信息
     * @return 产品贷后监控规则id
     */
    @ApiOperation(value = "新增产品贷后监控规则", notes = "新增产品贷后监控规则", httpMethod = "POST")
    @RequestMapping(value = "productLoanMonitor", method = RequestMethod.POST)
    public ResultTo productLoanMonitor(@ApiParam("产品审批流程") @ModelAttribute TProductLoanMonitorRules tProductLoanMonitorRules) {
        Integer flag = tProductLoanMonitorRulesService.insert(tProductLoanMonitorRules);
        return null != flag ? new ResultTo().setData(tProductLoanMonitorRules.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR.getValue());
    }

    /**
     * 新增产品贷后监控规则
     *
     * @param tProductRiskRules 产品贷后监控规则信息
     * @return 产品贷后监控规则id
     */
    @ApiOperation(value = "新增产品贷后监控规则", notes = "新增产品贷后监控规则", httpMethod = "POST")
    @RequestMapping(value = "productLoanMonitor", method = RequestMethod.POST)
    public ResultTo productRiskRules(@ApiParam("产品审批流程") @ModelAttribute TProductRiskRules tProductRiskRules) {
        Integer flag = tProductRiskRulesService.insert(tProductRiskRules);
        return null != flag ? new ResultTo().setData(tProductRiskRules.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR.getValue());
    }

}
