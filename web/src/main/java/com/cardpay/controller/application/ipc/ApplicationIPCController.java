package com.cardpay.controller.application.ipc;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.mgt.application.ipc.basic.service.ApplicationIPCBasicService;
import com.cardpay.mgt.application.ipc.normal.model.vo.TemplateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 进件IPCController
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/11 15:54
 */
@RestController
@RequestMapping("/api/application/ipc")
public class ApplicationIPCController {

    @Autowired
    private ApplicationIPCBasicService applicationIPCBasicService;

    /**
     * 根据模板查询ipc财务报表
     *
     * @param applicationId 进件Id
     * @param templateId    模板Id
     * @return
     */
    @GetMapping("/{applicationId}/{templateId}")
    public ResultTo selectIPC(@PathVariable("applicationId") Integer applicationId, @PathVariable("templateId") Integer templateId) {
        ResultTo resultTo = new ResultTo();
        List<TemplateGroup> balanceCrossGroups = applicationIPCBasicService.selectGroupEntrance(applicationId, templateId);
        resultTo.setData(balanceCrossGroups);
        return resultTo;
    }
}
