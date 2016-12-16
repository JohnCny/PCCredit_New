package com.cardpay.core.aop;

import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.common.annotation.SystemServiceLog;
import com.cardpay.basic.common.log.LogBase;
import com.cardpay.basic.util.PropertiesUtil;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.user.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static com.cardpay.basic.common.log.LogTemplate.error;

/**
 * 日志切面,包括ControlService的处理
 * @author licho on 2016/6/5.
 */
@Aspect
@Component
public class SystemLogAspect {
    //本地异常日志记录对象
    private static final Logger logger = LogBase.get();

    //Controller层切点
    @Pointcut("@annotation(com.cardpay.basic.common.annotation.SystemControllerLog)")
    public void controllerAspect() {
    }

    /**
     * 请求用于打印Controller内方法的日志
     * @param joinPoint   JoinPoint
     */
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        if(PropertiesUtil.getProperties("openSyslogController").equals("yes")){
            printNormalLog(joinPoint);
        }
    }

    /**
     * 用于打印Controller内方法的日志
     * @param joinPoint JoinPoint
     */
    private void printNormalLog(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getResponse();

        //获取需要展示数据信息
        User user = ShiroKit.getUser();
        String ip = request.getRemoteAddr();
        String requestMethod = request.getMethod();
        String requestURI = request.getRequestURI();
        String requestProtocol = request.getProtocol();
        Map<String, String[]> paramMap = request.getParameterMap();
        StringBuffer hsr = new StringBuffer();
        hsr.append(requestMethod);
        hsr.append(" ");
        hsr.append(requestURI);
        hsr.append(" ");
        hsr.append(requestProtocol);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String dt = sdf.format(new Date());
        int status = response.getStatus();
        int length = response.getBufferSize();
        String source = request.getHeader("referer");
        try {

            //获取param组成字符串
            String params = getParams(paramMap);
            String desc = getControllerMethodDescription(joinPoint);
            String methodName = joinPoint.getTarget().getClass().getName();
            logger.info("{} {} {}- - [{}] \"{} {}\" {} \"{}\" {}\" {}\" \"{}\"",
                    ip, user.getId(), user.getUsername(), dt, hsr, status, length, source,desc, methodName,params);
        } catch (Exception e) {
            //记录本地异常日志
            error(SystemLogAspect.class, e, "exception info:", e.getMessage());
        }
    }

    //Service层切点
    @Pointcut("@annotation(com.cardpay.basic.common.annotation.SystemServiceLog)")
    public void serviceAspect() {
    }

    /**
     *
     * @param joinPoint
     */
    /**
     * 正常通知 用于拦截service层记录正常日志信息
     * @param joinPoint JoinPoint
     * @return proceed对象
     * @throws Throwable
     */
    @Around("serviceAspect()")
    public Object doServiceAfter(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed ;
        if(PropertiesUtil.getProperties("openSyslogController").equals("yes")){
            proceed = printServiceLog(joinPoint);
        }else{
            proceed = joinPoint.proceed();
        }
        return proceed;
    }

    private Object printServiceLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getThis().getClass().getName(); //通过代理获取当前类名
        String methodName = joinPoint.getSignature().getName(); //获取当前方法名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); //通过代理获取MethodSignature
        Method method = methodSignature.getMethod(); //获取method
        SystemServiceLog executeMessage = method.getAnnotation(SystemServiceLog.class);//通过反射获取ExecuteMessage自定义注解
        String message = executeMessage.description();
        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);//通过反射获取RequestMapping
        String[] urls = requestMapping == null ? null : requestMapping.value(); //获取url
        Object[] args = joinPoint.getArgs();     //获取参数
        Class[] parameterTypes = method.getParameterTypes(); //获取参数类型
        StringBuffer paramStr = new StringBuffer("");
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i] != null) {
                    if (args[i] instanceof ModelMap) { //移除modelMap无用参数
                        paramStr.append("[" + parameterTypes[i].getSimpleName() + "(" + i + 1 + ")>>忽略]");
                        continue;
                    }
                    paramStr.append("[" + parameterTypes[i].getSimpleName() + "(" + i + 1 + ")>>" + args[i].toString() + "]");
                    continue;
                }
                paramStr.append("[" + parameterTypes[i].getSimpleName() + "(" + i + 1 + ")>>null]");
            }
        }
        Object proceed ;
        long startTime = System.currentTimeMillis();
        proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        if (urls != null && urls.length > 0) {
            logger.info("执行[" + message + "]时,请求的地址:[" + urls[0] + "]");
        }
        logger.info("执行[" + message + "]时,调用的类[" + className + "],调用的的方法:[" + methodName + "]");
        logger.info("执行[" + message + "]时,传入参数[类型(位置):值]:" + paramStr.toString());
        if (proceed != null) {
            logger.info("执行[" + message + "]时,返回值为:[" + proceed.toString() + "]");
        }
        logger.info("执行[" + message + "]耗时(AOP)[" + (endTime - startTime) + "]毫秒");
        return proceed;
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     * @param joinPoint JoinPoint
     * @param e         Throwable
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        User user = ShiroKit.getUser();
        String ip = request.getRemoteAddr();

        //获取用户请求方法的参数并序列化为JSON格式字符串
        StringBuffer params = new StringBuffer();
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                params.append(joinPoint.getArgs()[i].toString());
            }
        }
        try {
            String exceptionLog = "异常代码:" + e.getClass().getName()
                    + "异常信息:" + e.getMessage()
                    + "异常方法:" + joinPoint.getTarget().getClass().getName()
                    + "." + joinPoint.getSignature().getName() + "()"
                    + "方法描述:" + getServiceMethodDescription(joinPoint)
                    + "讲求人id:" + user.getId()
                    + "讲求人name:" + user.getUsername()
                    + "请求IP:" + ip
                    + "请求参数:" + params;
            error(SystemLogAspect.class, e, "exception info:", exceptionLog);
        } catch (Exception ex) {
            //记录本地异常日志
            logger.error("异常信息:", ex.getMessage());
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception 异常
     */
    public static String getServiceMethodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception 异常
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 将参数按照个数组装返回
     * @param paramsMap 参数map
     * @return 返回组装参数接口
     */
    public static String getParams(Map<String,String[]> paramsMap){
        StringBuffer result = new StringBuffer();
        for (Map.Entry<String, String[]> entry : paramsMap.entrySet()) {
            StringBuffer valueTmp = new StringBuffer();
            for(String value:entry.getValue()){
                valueTmp.append(value+"  ");
            }
            result.append(entry.getKey() + "=" + valueTmp+" ");
        }
        return result.toString();
    }
}
