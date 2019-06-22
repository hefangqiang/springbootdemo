package com.example.demo.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description： 日志切面类
 * @author： Mr.He
 * @date： 2019-06-17 21:55
 **/
@Aspect
@Component
public class LogAopUtil {

    @Pointcut("execution(* com.example.demo.controller.UserController.*(..))")
    public void logAop(){}

    @Before("logAop()")
    public void doBefore(){
        ServletRequestAttributes servletRequestAttributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String url = request.getRequestURI();
        String method = request.getMethod();
        String remoteAddr = request.getRemoteAddr();
        System.out.println("requestURL:"+url+"  |method:"+method +"  |remoteAddr:"+remoteAddr);
    }

    @After("logAop()")
    public void doAfter() {
        System.out.println("doafter");
    }
}
