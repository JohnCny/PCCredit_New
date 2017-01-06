package com.cardpay.controller.application;


import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.mgt.application.balancecross.dao.TTemplateGroupMapper;
import com.cardpay.mgt.application.balancecross.model.vo.BalanceCrossGroup;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 进件Controller类
 * Created by chenkai on 2016/12/6.
 */
@RestController
@RequestMapping("/api/application")
@Api(value = "/api/application", description = "进件")
public class ApplicationController{

    @Autowired
    private TTemplateGroupMapper templateGroupMapper;

    @GetMapping("/tree")
    public ResultTo selectTree(){
        ResultTo resultTo = new ResultTo();
        List<BalanceCrossGroup> balanceCrossGroups = templateGroupMapper.selectBalanceCross(2, 1);
        resultTo.setData(balanceCrossGroups);
        return resultTo;
    }
}
