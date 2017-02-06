package com.cardpay.controller.application.ipc;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
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

    @Autowired
    private ApplicationTemplateVarService applicationTemplateVarService;

    @Autowired
    private ApplicationTemplateVarExtService applicationTemplateVarExtService;

    @Autowired
    private ApplicationCashProfitVarService applicationCashProfitVarService;

    @Autowired
    private ApplicationCashProfitExtService applicationCashProfitExtService;

    @GetMapping("/test")
    public ResultTo test(){
        applicationIPCBasicService.initTemplate(2);
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
     * 更新一般模板var
     *
     * @param tApplicationTemplateVar 一般类型模板bean
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
     * @param tApplicationTemplateVarExt 一般类型模板额外值bean
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
     * @param tApplicationTemplateVarExt 一般类型模板额外值bean
     * @return 更新结果
     */
    @PutMapping("/normalExt")
    public ResultTo updateNormalVarExt(TApplicationTemplateVarExt tApplicationTemplateVarExt){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationTemplateVarExtService.insertSelective(tApplicationTemplateVarExt);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 删除一般模板额外值
     *
     * @param tApplicationTemplateVarExt 一般类型模板额外值bean
     * @return 更新结果
     */
    @DeleteMapping("/normalExt")
    public ResultTo deleteNormalVarExt(TApplicationTemplateVarExt tApplicationTemplateVarExt){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationTemplateVarExtService.delete(tApplicationTemplateVarExt);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 更新现金流类型模板var
     *
     * @param applicationCashProfitVar 现金流模板类型varBean
     * @return 更新结果
     */
    @PutMapping("/cashProfit")
    public ResultTo updateCashProfitVar(TApplicationCashProfitVar applicationCashProfitVar){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationCashProfitVarService.updateSelectiveByPrimaryKey(applicationCashProfitVar);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 添加现金流类型模板varExt
     *
     * @param applicationCashProfitExt 现金流模板类型var额外值Bean
     * @return 添加结果
     */
    @PostMapping("/cashProfitExt")
    public ResultTo addCashProfitVarExt(TApplicationCashProfitExt applicationCashProfitExt){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationCashProfitExtService.insertSelective(applicationCashProfitExt);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 更新现金流类型模板varExt
     *
     * @param applicationCashProfitExt 现金流模板类型var额外值Bean
     * @return 更新结果
     */
    @PutMapping("/cashProfitExt")
    public ResultTo updateCashProfitVarExt(TApplicationCashProfitExt applicationCashProfitExt){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationCashProfitExtService.updateSelectiveByPrimaryKey(applicationCashProfitExt);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 删除现金流类型模板varExt
     *
     * @param applicationCashProfitExt 现金流模板类型var额外值Bean
     * @return 删除结果
     */
    @DeleteMapping("/cashProfitExt")
    public ResultTo deleteCashProfitVarExt(TApplicationCashProfitExt applicationCashProfitExt){
        ResultTo resultTo = new ResultTo();
        Integer result = applicationCashProfitExtService.delete(applicationCashProfitExt);
        resultTo.setIsSuccess(result);
        return resultTo;
    }
}
