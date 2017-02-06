package com.cardpay.mgt.application.ipc.basic.service.impl;

import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.basic.util.treeutil.exception.TreeInitializeException;
import com.cardpay.mgt.application.enums.IpcCRUDType;
import com.cardpay.mgt.application.enums.TemplateTypeEnum;
import com.cardpay.mgt.application.exception.NoSuchApplicationTemplateError;
import com.cardpay.mgt.application.ipc.basic.dao.ApplicationIPCBasicMapper;
import com.cardpay.mgt.application.ipc.basic.model.IPCMenu;
import com.cardpay.mgt.application.ipc.basic.service.ApplicationIPCBasicService;
import com.cardpay.mgt.application.ipc.cashflowprofit.dao.CashProfitTemplateMapper;
import com.cardpay.mgt.application.ipc.cashflowprofit.model.TApplicationCashProfitExt;
import com.cardpay.mgt.application.ipc.cashflowprofit.model.TApplicationCashProfitVar;
import com.cardpay.mgt.application.ipc.cashflowprofit.model.vo.CashProfitTemplateGroup;
import com.cardpay.mgt.application.ipc.cashflowprofit.service.ApplicationCashProfitExtService;
import com.cardpay.mgt.application.ipc.cashflowprofit.service.ApplicationCashProfitVarService;
import com.cardpay.mgt.application.ipc.normal.dao.NormalTemplateMapper;
import com.cardpay.mgt.application.ipc.normal.dao.TApplicationTemplateMapper;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplate;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplateVar;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplateVarExt;
import com.cardpay.mgt.application.ipc.normal.model.vo.TemplateGroup;
import com.cardpay.mgt.application.ipc.normal.service.ApplicationTemplateVarExtService;
import com.cardpay.mgt.application.ipc.normal.service.ApplicationTemplateVarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 进件IPC基础操作Service实现类
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/11 14:42
 */
@Service
public class ApplicationIPCBasicServiceImpl implements ApplicationIPCBasicService{

    @Autowired
    private ApplicationIPCBasicMapper applicationIPCBasicMapper;

    @Autowired
    private NormalTemplateMapper normalTemplateMapper;

    @Autowired
    private CashProfitTemplateMapper cashProfitTemplateMapper;

    @Autowired
    private TApplicationTemplateMapper applicationTemplateMapper;

    @Autowired
    private ApplicationTemplateVarService applicationTemplateVarService;

    @Autowired
    private ApplicationTemplateVarExtService applicationTemplateVarExtService;

    @Autowired
    private ApplicationCashProfitVarService applicationCashProfitVarService;

    @Autowired
    private ApplicationCashProfitExtService applicationCashProfitExtService;

    @Override
    @Transactional
    public Integer initTemplate(Integer applicationId) {
        List<Integer> types = applicationIPCBasicMapper.selectTemplateTypeByApplicationId(applicationId);
        Integer result = 0;
        for (Integer type : types) {
            result += applicationIPCBasicMapper.initNormalTemplate(applicationId, type);
        }
        return result;
    }

    @Override
    public Object selectGroupEntrance(Integer applicationId, Integer templateId) throws NoSuchApplicationTemplateError {
        //查询模板对应的类型
        TApplicationTemplate template = applicationTemplateMapper.selectByPrimaryKey(templateId);
        if(template==null){
            NoSuchApplicationTemplateError exception = new NoSuchApplicationTemplateError("进件id：" + applicationId + "模板id：" + templateId + "模板不存在");
            LogTemplate.error(exception,"模板不存在","进件id：" + applicationId + "模板id：" + templateId + "模板不存在");
            throw exception;
        }
        //根据类型查询模板
        switch (TemplateTypeEnum.getTemplateTypeEnumById(template.getTemplateType())){
            case NORMAL:
                return normalTemplateMapper.selectGroupEntrance(applicationId, templateId);
            case APPLICATION_FROM:
                return normalTemplateMapper.selectGroupEntrance(applicationId, templateId);
            case CASHFLOW_PROFIT:
                List<CashProfitTemplateGroup> cashProfitTemplateGroups =
                        cashProfitTemplateMapper.selectGroupEntrance(applicationId, templateId);
                return cashProfitTemplateGroups;
            default:
                break;
        }
        LogTemplate.error(null,"模板类型错误","进件id：" + applicationId + "模板id：" + templateId + "模板类型错误");
        throw new NoSuchApplicationTemplateError("进件id：" + applicationId + "模板id：" + templateId + "模板类型错误");
    }

    @Override
    public List<IPCMenu> selectIPCMenu(Integer applicationId) {
        TreeUtil<IPCMenu> treeUtil = new TreeUtil<>("menuOrder",TreeUtil.ASC);
        List<IPCMenu> ipcMenus = applicationIPCBasicMapper.selectIPCMenu(applicationId);
        List<IPCMenu> resultMenu = null;
        try {
            resultMenu = treeUtil.getChildNodesByParentId(ipcMenus, 0);
        } catch (TreeInitializeException e) {
            LogTemplate.error(e,"IPC菜单数据组装层级错误",e.getMessage());
            e.printStackTrace();
        }
        return resultMenu;
    }

    @Override
    public Integer updateIPC(Object object, Integer ipcCRUDType) {
        IpcCRUDType ipcCRUDTypeEnum = IpcCRUDType.getIpcCRUDTypeById(ipcCRUDType);
        Integer result = null;
        switch (ipcCRUDTypeEnum){
            case NORMAL_VAR:
                TApplicationTemplateVar applicationTemplateVar = (TApplicationTemplateVar) object;
                result = applicationTemplateVarService.updateSelectiveByPrimaryKey(applicationTemplateVar);
                break;
            case NORMAL_EXT:
                TApplicationTemplateVarExt applicationTemplateVarExt = (TApplicationTemplateVarExt) object;
                result = applicationTemplateVarExtService.updateSelectiveByPrimaryKey(applicationTemplateVarExt);
                break;
            case CASHFLOW_PROFIT_VAR:
                TApplicationCashProfitVar applicationCashProfitVar = (TApplicationCashProfitVar) object;
                result = applicationCashProfitVarService.updateSelectiveByPrimaryKey(applicationCashProfitVar);
                break;
            case CASHFLOW_PROFIT_EXT:
                TApplicationCashProfitExt applicationCashProfitExt = (TApplicationCashProfitExt) object;
                result = applicationCashProfitExtService.updateSelectiveByPrimaryKey(applicationCashProfitExt);
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    public Integer addIPC(Object object, Integer ipcCRUDType) {
        IpcCRUDType ipcCRUDTypeEnum = IpcCRUDType.getIpcCRUDTypeById(ipcCRUDType);
        Integer result = null;
        switch (ipcCRUDTypeEnum){
            case NORMAL_EXT:
                TApplicationTemplateVarExt applicationTemplateVarExt = (TApplicationTemplateVarExt) object;
                result = applicationTemplateVarExtService.insertSelective(applicationTemplateVarExt);
                break;
            case CASHFLOW_PROFIT_EXT:
                TApplicationCashProfitExt applicationCashProfitExt = (TApplicationCashProfitExt) object;
                result = applicationCashProfitExtService.insertSelective(applicationCashProfitExt);
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    public Integer deleteIPC(Object object, Integer ipcCRUDType) {
        IpcCRUDType ipcCRUDTypeEnum = IpcCRUDType.getIpcCRUDTypeById(ipcCRUDType);
        Integer result = null;
        switch (ipcCRUDTypeEnum){
            case NORMAL_EXT:
                TApplicationTemplateVarExt applicationTemplateVarExt = (TApplicationTemplateVarExt) object;
                result = applicationTemplateVarExtService.delete(applicationTemplateVarExt);
                break;
            case CASHFLOW_PROFIT_EXT:
                TApplicationCashProfitExt applicationCashProfitExt = (TApplicationCashProfitExt) object;
                result = applicationCashProfitExtService.delete(applicationCashProfitExt);
                break;
            default:
                break;
        }
        return result;
    }
}
