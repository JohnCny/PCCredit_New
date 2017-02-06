package com.cardpay.controller.application.ipc;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.mgt.application.annotation.IpcCRUD;
import com.cardpay.mgt.application.exception.NoSuchApplicationTemplateError;
import com.cardpay.mgt.application.ipc.basic.model.IPCMenu;
import com.cardpay.mgt.application.ipc.basic.service.ApplicationIPCBasicService;
import com.cardpay.mgt.application.ipc.cashflowprofit.model.TApplicationCashProfitExt;
import com.cardpay.mgt.application.ipc.cashflowprofit.model.TApplicationCashProfitVar;
import com.cardpay.mgt.application.ipc.cashflowprofit.service.ApplicationCashProfitExtService;
import com.cardpay.mgt.application.ipc.cashflowprofit.service.ApplicationCashProfitVarService;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplateVar;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplateVarExt;
import com.cardpay.mgt.application.ipc.normal.model.vo.TemplateGroup;
import com.cardpay.mgt.application.ipc.normal.service.ApplicationTemplateVarExtService;
import com.cardpay.mgt.application.ipc.normal.service.ApplicationTemplateVarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 进件IPC Controller
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/11 15:54
 */
@RestController
@RequestMapping("/api/application/ipc")
public class ApplicationIPCController {

    @Autowired
    private ApplicationIPCBasicService applicationIPCBasicService;

    @RequestMapping("/test")
    public ResultTo test(){
        
        return new ResultTo();
    }

    /**
     * 根据模板查询ipc财务报表
     *
     * @param applicationId 进件Id
     * @param templateId    模板Id
     * @return
     */
    @GetMapping("/{applicationId}/{templateId}")
    public ResultTo selectIPC(@PathVariable("applicationId") Integer applicationId
            , @PathVariable("templateId") Integer templateId) {
        ResultTo resultTo = new ResultTo();
        try {
            Object template = applicationIPCBasicService.selectGroupEntrance(applicationId, templateId);
            resultTo.setData(template);
        } catch (NoSuchApplicationTemplateError noSuchApplicationTemplateError) {
            resultTo.setMsg(ResultEnum.OPERATION_FAILED.getValue(),noSuchApplicationTemplateError.getMessage());
        }
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
     * 更新var
     *
     * @param object 实体Bean
     * @param ipcCRUDType 类型 参考IpcCRUDType枚举
     * @return 更新结果
     */
    @PutMapping()
    public ResultTo updateNormalVar(@IpcCRUD Object object,@RequestParam("ipcCRUDType") Integer ipcCRUDType){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationIPCBasicService.updateIPC(object,ipcCRUDType);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 添加模板额外值
     *
     * @param object 实体Bean
     * @param ipcCRUDType 类型 参考IpcCRUDType枚举
     * @return 添加结果
     */
    @PostMapping()
    public ResultTo addNormalVarExt(@IpcCRUD Object object,@RequestParam("ipcCRUDType") Integer ipcCRUDType){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationIPCBasicService.addIPC(object,ipcCRUDType);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 删除模板额外值
     *
     * @param object 实体Bean
     * @param ipcCRUDType 类型 参考IpcCRUDType枚举
     * @return 删除结果
     */
    @DeleteMapping()
    public ResultTo deleteNormalVarExt(@IpcCRUD Object object,@RequestParam("ipcCRUDType") Integer ipcCRUDType){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationIPCBasicService.deleteIPC(object,ipcCRUDType);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

}
