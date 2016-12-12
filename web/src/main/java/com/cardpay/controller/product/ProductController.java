package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
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

    /**
     * 添加产品信息接口
     * @param tProduct 产品信息
     * @param file 图片信息(需要上传)
     * @return 产品id
     */
    @ApiOperation(value = "添加产品信息接口", notes = "添加产品基本信息", httpMethod = "POST")
    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public ResultTo insertProduct(@ApiParam(value = "产品信息", required = true) @ModelAttribute TProduct tProduct
            , @ApiParam(value = "图片信息(需要上传)", required = true)  @RequestPart MultipartFile file) {
        //上传产品图片
        String upLoadParam = fileManager.upLoad(file);
        String[] split = upLoadParam.split(",");
        tProduct.setProductPictureUrl(split[0] + "," + split[1]);
        tProduct.setCreateTime(new Date());
        tProduct.setModifyTime(new Date());
        tProductService.insert(tProduct);
        //若添加失败则删除fastDfs上的文件
        if (tProduct.getId() == null) {
            fileManager.deleteFile(split[0], split[1]);
        }
        return new ResultTo().setData(tProduct.getId());
    }

    /**
     * 更新产品信息接口
     * @param tProduct 产品信息
     * @param file 图片信息(需要上传)
     * @return 数据库变更个数
     */
    @ApiOperation(value = "更新产品信息接口", notes = "更新产品基本信息", httpMethod = "POST")
    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public ResultTo updateProduct(@ApiParam(value = "产品信息", required = true) @ModelAttribute TProduct tProduct
            , @ApiParam(value = "图片信息(需要上传)")  @RequestPart(value = "file", required = false) MultipartFile file) {
        //若重新上传图片则删除以前上传的图片信息
        if (null != file) {
            TProduct queryProduct = tProductService.selectByPrimaryKey(tProduct.getId());
            String[] split = queryProduct.getProductPictureUrl().split(",");
            Integer flag = fileManager.deleteFile(split[0], split[1]);
            if (null != flag) {
                String upLoadParam = fileManager.upLoad(file);
                String[] param = upLoadParam.split(",");
                tProduct.setProductPictureUrl(param[0] + "," + param[1]);
            }
        }
        Integer sum = tProductService.updateSelectiveByPrimaryKey(tProduct);
        return new ResultTo().setData(sum);
    }

}
