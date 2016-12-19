package com.cardpay.controller.application;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.application.model.TApplication;
import com.cardpay.mgt.application.service.TApplicationService;
import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 进件Controller类
 * Created by chenkai on 2016/12/6.
 */
@RestController
@RequestMapping("/application/")
@Api(value = "/application", description = "进件Controller类")
public class ApplicationController extends BaseController<TApplication, Integer> {
    @Autowired //进件
    private TApplicationService tApplicationService;

    @Autowired
    private FileManager fileManager;

    /*  @Autowired //产品
      private TProductService tProductService;

    @Autowired//客户经理
    private TManagerService tManagerService;
  */
    @RequestMapping
    public ResultTo productNext(@ApiParam(value = "产品ID", required = true) @RequestParam("id") int productId) {
        User user = (User) ShiroKit.getPrincipal();
     /*   TManager tManager = tManagerService.get(user.getId());
        TProduct tProduct =tProductService.get(id);
        if(tManager.getsmallnt()){

        }*/
        return new ResultTo();
    }


}
