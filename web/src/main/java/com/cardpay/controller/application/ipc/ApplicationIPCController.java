package com.cardpay.controller.application.ipc;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.mgt.application.ipc.basic.model.IPCMenu;
import com.cardpay.mgt.application.ipc.basic.service.ApplicationIPCBasicService;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplateVar;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplateVarExt;
import com.cardpay.mgt.application.ipc.normal.model.vo.TemplateGroup;
import com.cardpay.mgt.application.ipc.normal.service.ApplicationTemplateVarExtService;
import com.cardpay.mgt.application.ipc.normal.service.ApplicationTemplateVarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ApplicationTemplateVarService applicationTemplateVarService;

    @Autowired
    private ApplicationTemplateVarExtService applicationTemplateVarExtService;
    /**
     * 根据模板查询ipc财务报表
     *
     * @param applicationId 进件Id
     * @param templateId    模板Id
     * @return
     */
    @GetMapping("/{applicationId}/{templateType}/{templateId}")
    public ResultTo selectIPC(@PathVariable("applicationId") Integer applicationId
            , @PathVariable("templateType") Integer templateType, @PathVariable("templateId") Integer templateId) {
        ResultTo resultTo = new ResultTo();
        Object template = applicationIPCBasicService.selectGroupEntrance(applicationId, templateId, templateType);
        resultTo.setData(template);
        return resultTo;
    }

    /**
     * 根据模板查询ipc财务报表
     *
     * @param applicationId 进件Id
     * @return
     */
    @GetMapping("/menu/{applicationId}")
    public ResultTo selectIPCMenu(@PathVariable("applicationId") Integer applicationId) {
        ResultTo resultTo = new ResultTo();
        List<IPCMenu> ipcMenus = applicationIPCBasicService.selectIPCMenu(applicationId);
        resultTo.setData(ipcMenus);
        return resultTo;
    }

    /**
     * 更新一般模板var
     *
     * @param tApplicationTemplateVar
     * @return
     */
    @PutMapping("/normal")
    public ResultTo updateNormalVar(TApplicationTemplateVar tApplicationTemplateVar){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationTemplateVarService.updateSelectiveByPrimaryKey(tApplicationTemplateVar);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 添加一般模板额外值
     *
     * @param tApplicationTemplateVarExt
     * @return
     */
    @PostMapping("/normalExt")
    public ResultTo addNormalVarExt(TApplicationTemplateVarExt tApplicationTemplateVarExt){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationTemplateVarExtService.insertSelective(tApplicationTemplateVarExt);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 更新一般模板额外值
     *
     * @param tApplicationTemplateVarExt
     * @return
     */
    @PutMapping("/normalExt")
    public ResultTo updateNormalVarExt(TApplicationTemplateVarExt tApplicationTemplateVarExt){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationTemplateVarExtService.insertSelective(tApplicationTemplateVarExt);
        resultTo.setIsSuccess(result);
        return resultTo;
    }
}
