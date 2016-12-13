package com.cardpay.basic.common.aop;

import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.common.annotation.SystemServiceLog;
import com.cardpay.basic.common.log.LogTemplate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.cardpay.basic.common.log.LogTemplate.error;


/**
 * 日志切面,包括ControlService的处理
 *
 * @author licho on 2016/6/5.
 */
@Aspect
@Component
public class SystemLogAspect {

    //本地异常日志记录对象
    @Autowired
    private LogTemplate logger;

    //Controller层切点
    @Pointcut("@annotation(com.cardpay.basic.common.annotation.SystemControllerLog)")
    public void controllerAspect() {
    }

    //Service层切点
    @Pointcut("@annotation(com.cardpay.basic.common.annotation.SystemServiceLog)")
    public void serviceAspect() {
    }

    /**
     * 用于打印Controller内方法的日志
     *
     * @param joinPoint JoinPoint
     */
    private void printNormalLog(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getResponse();

//        User user = SubjectUtil.getSubject(request);
        String ip = request.getRemoteAddr();
        String requestMethod = request.getMethod();
        String requestURI = request.getRequestURI();
        String requestProtocol = request.getProtocol();
        StringBuffer hsr = new StringBuffer();
        hsr.append(requestMethod);
        hsr.append(" ");
        hsr.append(requestURI);
        hsr.append(" ");
        hsr.append(requestProtocol);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//        String dt = sdf.format(new Date());
//        int status = response.getStatus();
//        int length = response.getBufferSize();
//        String source = request.getHeader("referer");
//        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));

        try {
//            String methodName = joinPoint.getTarget().getClass().getName();

//            logger.info("{} {}- - [{}] \"{} {}\" {} \"{}\" \"{}\"",
//                    ip, user.getName(), dt, hsr, status, length, source, userAgent.toString());
        } catch (Exception e) {
            //记录本地异常日志
            error(SystemLogAspect.class, e, "exception info:", e.getMessage());
        }
    }

    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        printNormalLog(joinPoint);
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     *
     * @param joinPoint JoinPoint
     * @param e         Throwable
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {

        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
//        User user = SubjectUtil.getSubject(request);
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
//                    + "讲求人:" + user.getName()
                    + "请求IP:" + ip
                    + "请求参数:" + params;
            error(SystemLogAspect.class, e, "exception info:", exceptionLog);
        } catch (Exception ex) {
            //记录本地异常日志
            logger.error(SystemLogAspect.class, ex, "异常信息:", ex.getMessage());
        }
        /*==========记录本地异常日志==========*/
/*        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}",
                joinPoint.getTarget().getClass().getName()
                        + joinPoint.getSignature().getName(),
                e.getClass().getName(), e.getMessage(), params);*/

    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
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
}
