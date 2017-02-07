package com.cardpay.controller.index;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.mgt.index.dao.IndexOrgApplicationMapper;
import com.cardpay.mgt.index.model.IndexOrgApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * BaseLogin控制层
 *
 * @author rankai
 */
@RestController
@RequestMapping("/api/index")
public class IndexController {

    @Autowired
    private IndexOrgApplicationMapper indexOrgApplicationMapper;

    @GetMapping
    public ResultTo index() {
        ResultTo resultTo = new ResultTo();
        List<IndexOrgApplicationInfo> indexOrgApplicationInfo = indexOrgApplicationMapper.selectOrgApplicationInfo(1);
        resultTo.setData(indexOrgApplicationInfo);
        return resultTo;
    }
}
