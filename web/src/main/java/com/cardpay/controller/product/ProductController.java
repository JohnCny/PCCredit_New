package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.mgt.product.model.*;
import com.cardpay.mgt.product.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
@RequestMapping("/api/product")
@Api(value = "/api/product", description = "产品管理")
public class ProductController extends BaseController<Product> {


    /**
     * 获取产品分页数据
     *
     * @return 产品分页数据
     */
    @GetMapping("/pageList")
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "产品分页数据", httpMethod = "GET")
    public DataTablePage pageList() {
        return dataTablePage();
    }

}
