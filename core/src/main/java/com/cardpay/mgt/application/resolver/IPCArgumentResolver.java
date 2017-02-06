package com.cardpay.mgt.application.resolver;

import com.cardpay.mgt.application.annotation.IpcCRUD;
import com.cardpay.mgt.application.enums.IpcCRUDType;
import com.cardpay.mgt.application.ipc.cashflowprofit.model.TApplicationCashProfitExt;
import com.cardpay.mgt.application.ipc.cashflowprofit.model.TApplicationCashProfitVar;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplateVar;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplateVarExt;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.ServletRequest;
import java.util.Enumeration;

public class IPCArgumentResolver implements HandlerMethodArgumentResolver {
  
    @Override  
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(IpcCRUD.class);
    }  
  
    @Override  
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Integer ipcCRUDType = Integer.valueOf(webRequest.getParameter("ipcCRUDType"));
        IpcCRUDType ipcCRUDTypeEnum = IpcCRUDType.getIpcCRUDTypeById(ipcCRUDType);
        Object obj = null;
        switch (ipcCRUDTypeEnum){
            case NORMAL_VAR:
                obj = resolveBean(TApplicationTemplateVar.class, webRequest, binderFactory);
                break;
            case NORMAL_EXT:
                obj = resolveBean(TApplicationTemplateVarExt.class, webRequest, binderFactory);
                break;
            case CASHFLOW_PROFIT_VAR:
                obj = resolveBean(TApplicationCashProfitVar.class, webRequest, binderFactory);
                break;
            case CASHFLOW_PROFIT_EXT:
                obj = resolveBean(TApplicationCashProfitExt.class, webRequest, binderFactory);
                break;
            default:
                break;
        }
        return obj;
    }

    /**
     * 转换bean
     *
     * @param beanClass 类型
     * @param webRequest request
     * @param binderFactory binderFactory
     * @return 转换后的实体Bean
     * @throws Exception 创建Bean异常
     */
    private Object resolveBean(Class beanClass,NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String objName = beanClass.getSimpleName();
        Object obj = BeanUtils.instantiateClass(beanClass);
        WebDataBinder binder = binderFactory.createBinder(webRequest, obj, objName);
        Object target = binder.getTarget();
        if(target != null) {
            bindParameters(webRequest, binder, objName);
        }
        return target;
    }

    /**
     * 绑定参数方法
     *
     * @param request request
     * @param binder  binder
     * @param objName objName
     */
    private void bindParameters(NativeWebRequest request, WebDataBinder binder, String objName) {
        ServletRequest servletRequest = request.getNativeRequest(ServletRequest.class);

        MockHttpServletRequest newRequest = new MockHttpServletRequest();

        Enumeration<String> enu = servletRequest.getParameterNames();
        while(enu.hasMoreElements()) {
            String paramName = enu.nextElement();
            if(paramName.startsWith(objName)) {
                newRequest.setParameter(paramName.substring(objName.length()+1), request.getParameter(paramName));
            } else {
                newRequest.setParameter(paramName, request.getParameter(paramName));
            }
        }
        ((ExtendedServletRequestDataBinder)binder).bind(newRequest);
    }
}