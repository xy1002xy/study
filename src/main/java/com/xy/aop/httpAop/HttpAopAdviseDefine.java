package com.xy.aop.httpAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-11-04 11:22
 * @desc:
 **/
public class HttpAopAdviseDefine {

    @Pointcut("@annotation(com.xy.aop.httpAop.AutoCheck)")
    public void point(){

    }

    @Around("point()")
    public Object checkAuth(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
       HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
       String token=getUserToken(request);
       if (!"123456".equalsIgnoreCase(token)){
           return "认证失败，请检查输入的token值";
       }
        return proceedingJoinPoint.proceed();
    }

    public String getUserToken(HttpServletRequest request){
        Cookie []cookies=request.getCookies();
        if (cookies==null){
            return "";
        }
        for (Cookie cookie :cookies){
            if (cookie.getName().equalsIgnoreCase("user_token")){
                return cookie.getValue();
            }
        }
        return "";
    }

}
