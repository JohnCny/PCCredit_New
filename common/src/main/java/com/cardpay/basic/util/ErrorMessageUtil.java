package com.cardpay.basic.util;

import com.cardpay.basic.common.log.LogTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

/**
 * validate 参数验证错误信息组装
 *
 * @author rankai .
 */
public class ErrorMessageUtil {

    /**
     * 组装错误数据 redirectAttributes
     *
     * @param redirectAttributes 页面跳转传递参数对象
     * @param errors             验证错误对象
     * @return true存在错误，false不存在错误
     */
    public static boolean setValidErrorMessage(RedirectAttributes redirectAttributes, Errors... errors) {
        Boolean flag = Boolean.FALSE;
        for (int i = 0; i < errors.length; i++) {
            if (errors[i].getErrorCount() > 0) {
                for (FieldError error : errors[i].getFieldErrors()) {
                    redirectAttributes.addFlashAttribute(error.getField() + "Error", error.getDefaultMessage());
                    LogTemplate.info(ErrorMessageUtil.class, "传入参数有误:{}", error.getField() + ":" + error.getDefaultMessage());
                }
                if (!flag) {
                    flag = Boolean.TRUE;
                }
            }
        }
        return flag;
    }

    /**
     * 组装错误数据  map
     *
     * @param map    错误接收对象，Map类型
     * @param errors 验证错误对象
     * @return true存在错误，false不存在错误
     */
    public static boolean setValidErrorMessage(Map<String, String> map, BindingResult... errors) {
        Boolean flag = Boolean.FALSE;
        for (int i = 0; i < errors.length; i++) {
            if (errors[i].getErrorCount() > 0) {
                for (FieldError error : errors[i].getFieldErrors()) {
                    LogTemplate.info(ErrorMessageUtil.class, "传入参数有误:{}", error.getField() + ":" + error.getDefaultMessage());
                    map.put(error.getField() + "Error", error.getDefaultMessage());
                }
                if (!flag) {
                    flag = Boolean.TRUE;
                }
            }
        }
        return flag;
    }
}
