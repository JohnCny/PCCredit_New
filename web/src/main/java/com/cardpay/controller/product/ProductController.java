package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.controller.base.BaseController;
import com.cardpay.controller.organization.OrganizationController;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.product.model.*;
import com.cardpay.mgt.product.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


/**
 * 产品管理Controller
 *
 * @author chenkai on 2016/12/8.
 */
@Controller
@RequestMapping("/product")
@Api(value = "/product", description = "产品管理")
public class ProductController extends BaseController<TProduct, Integer> {
    @Autowired //产品Service
    private TProductService tProductService;

    @Autowired //fastDfs Service
    private FileManager fileManager;

    @Autowired
    private static LogTemplate logger;

    /**
     * 添加产品信息接口
     *
     * @param tProduct 产品信息
     * @param file     图片信息(需要上传)
     * @return 产品id
     */
    @ResponseBody
    @PostMapping("/new")
    @ApiOperation(value = "添加产品信息接口", notes = "添加产品基本信息", httpMethod = "POST")
    public ResultTo insertProduct(@ApiParam(value = "产品信息") @ModelAttribute TProduct tProduct
            , @ApiParam(value = "图片信息(需要上传)", required = true) @RequestPart MultipartFile file) {
        //上传产品图片
        String upLoadParam = fileManager.upLoad(file);
        tProduct.setProductPictureUrl(upLoadParam);
        tProduct.setCreateTime(new Date());
        tProduct.setModifyTime(new Date());
        tProductService.insertSelective(tProduct);
        logger.info("新建产品", "产品id:" + tProduct.getId());
        //若添加失败则删除fastDfs上的文件
        if (tProduct.getId() == null) {
            String[] split = upLoadParam.split(",");
            fileManager.deleteFile(split[0], split[1]);
        }
        return new ResultTo().setData(tProduct.getId());
    }

    /**
     * 更新产品信息接口
     *
     * @param tProduct 产品信息
     * @param file     图片信息(需要上传)
     * @return 数据库变更个数
     */
    @ResponseBody
    @PutMapping("/")
    @ApiOperation(value = "更新产品信息接口", notes = "更新产品基本信息", httpMethod = "PUT")
    public ResultTo updateProduct(@ApiParam(value = "产品信息", required = true) @ModelAttribute TProduct tProduct
            , @ApiParam(value = "图片信息(需要上传)") @RequestPart(value = "file", required = false) MultipartFile file) {
        //若重新上传图片则删除以前上传的图片信息
        if (null != file) {
            TProduct queryProduct = tProductService.selectByPrimaryKey(tProduct.getId());
            //拆分文件路径用于删除文件
            String[] split = queryProduct.getProductPictureUrl().split("/");
            String path = null;
            for (int i = 1; i < split.length; i++) {
                path += split[i];
            }
            Integer flag = fileManager.deleteFile(split[0], path);
            //更新图片信息
            if (null != flag) {
                String upLoadParam = fileManager.upLoad(file);
                tProduct.setProductPictureUrl(upLoadParam);
                logger.info("更新产品图片", "产品id:" + tProduct.getId());
            }
        }
        Integer count = tProductService.updateSelectiveByPrimaryKey(tProduct);
        return new ResultTo().setData(count);
    }

}
