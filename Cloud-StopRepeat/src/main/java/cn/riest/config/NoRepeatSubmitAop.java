package cn.riest.config;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import com.google.common.cache.Cache;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
//@Order(1000)
public class NoRepeatSubmitAop {

    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private Cache<String, Integer> cache;

    public NoRepeatSubmitAop() {
    }

    @Pointcut("@annotation(cn.riest.config.NoRepeatSubmit)")
    public void StopRepeat() {
    }

    @Pointcut("execution(* cn.riest.controller.RepeatController.getContent())")
    public void packageLimitPath() {
    }

    @Before("StopRepeat() && @annotation(noRepeatSubmit) &&packageLimitPath()")
    public void doBefore(JoinPoint joinPoint, NoRepeatSubmit noRepeatSubmit) {
        System.out.println("-------切入该注解1--------");
    }
    @Before("packageLimitPath()")
    public void doBefore1(JoinPoint joinPoint) {
        System.out.println("-------切入该注解2--------");
    }


//    @Pointcut("@annotation(cn.riest.config.NoRepeatSubmit)")
//    public void pointCut(NoRepeatSubmit noRepeatSubmit) {
//    }
//
//    @Around("pointCut(noRepeatSubmit) && @annotation(noRepeatSubmit)")
//    public Object arround(ProceedingJoinPoint pjp, NoRepeatSubmit noRepeatSubmit) {
//        System.out.println("切面拦截 到 该业务");
//        try {
//            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
//            HttpServletRequest request = attributes.getRequest();
//            String key = sessionId + "-" + request.getServletPath();
//            if (cache.getIfPresent(key) == null) {// 如果缓存中有这个url视为重复提交
//                Object o = pjp.proceed();
//                cache.put(key, 0);
//                return o;
//            } else {
//                logger.error("重复请求，请稍后在试试。");
//                return null;
//            }
//        } catch (Throwable e) {
//            e.printStackTrace();
//            logger.error("验证重复提交时出现未知异常!");
//            return "{\"code\":-889,\"message\":\"验证重复提交时出现未知异常!\"}";
//        }
//    }

}
