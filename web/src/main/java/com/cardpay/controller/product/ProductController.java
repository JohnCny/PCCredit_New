package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.mgt.product.model.TProduct;
import com.cardpay.mgt.product.model.TProductInvestPictureDesc;
import com.cardpay.mgt.product.service.TProductInvestPictureDescService;
import com.cardpay.mgt.product.service.TProductOrganizationService;
import com.cardpay.mgt.product.service.TProductService;
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

    @ApiOperation(value = "新增产品信息接口", notes = "添加产品基本信息", httpMethod = "POST")
    @RequestMapping(value = "insertProduct", method = RequestMethod.POST)
    public ResultTo insertProduct(@ApiParam(value = "产品信息", required = true) @ModelAttribute TProduct tProduct
            , @ApiParam(value = "图片信息(需要上传)", required = true) @RequestPart MultipartFile file
            , @ApiParam(value = "机构id(','分割)", required = true) @RequestParam String orgIds
            ) {
        batchInsertOrg(tProduct.getId(), orgIds);
       // tProductInvestPictureDescService.batchInsertImg(TProductInvestPictureDescList);
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

    /**
     * 批量插入准入客户经理级别以及机构
     *
     * @param productId 产品id
     * @param orgIds    机构id集合
     * @return 插入数量
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
}
