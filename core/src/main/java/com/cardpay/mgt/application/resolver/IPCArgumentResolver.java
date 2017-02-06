package com.cardpay.mgt.application.resolver;

import com.cardpay.mgt.application.annotation.IpcCRUD;
import com.cardpay.mgt.application.enums.TemplateTypeEnum;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplateVar;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.ServletRequest;
import java.util.Enumeration;

public class IPCArgumentResolver implements HandlerMethodArgumentResolver {
  
    @Override  
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasMethodAnnotation(IpcCRUD.class);
    }  
  
    @Override  
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Integer ipcCRUDType = (Integer) webRequest.getAttribute("ipcCRUDType", RequestAttributes.SCOPE_REQUEST);
        TemplateTypeEnum templateTypeEnum = TemplateTypeEnum.getTemplateTypeEnumById(ipcCRUDType);
        Object obj = null;
        switch (templateTypeEnum){
            case NORMAL:
                obj = resolveBean(TApplicationTemplateVar.class, webRequest, binderFactory);
                break;
            default:
                break;
        }
        return obj;
    }

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