package com.cardpay.controller.index;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.mgt.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * BaseLogin控制层
 *
 * @author rankai
 */
@RestController
@RequestMapping("/api/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping
    public ResultTo index() {
        ResultTo resultTo = indexService.getIndexInfo();
        return resultTo;
    }
}
