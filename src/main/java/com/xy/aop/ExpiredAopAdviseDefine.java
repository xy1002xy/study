package com.xy.aop;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-11-03 12:19
 * @desc:
 **/

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


/**
 * @program: girl
 * @author: wxy
 * @create: 2018-11-03 11:47
 * @desc:
 **/
@Component
@Aspect
public class ExpiredAopAdviseDefine {

    private Logger logger= LoggerFactory.getLogger(getClass());

    //定义一个Pointcut,使用切点表达式函数来描述对那些Join point 使用advise
    @Pointcut("within(SomeService)")
    public void pointcut(){
    }

    //定义advise
    @Around("pointcut()")
    public Object methodInvokeExpiredTime(ProceedingJoinPoint joinPoint)throws Throwable{
        logger.info("============1111111111111111111==================");
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        Object retVal= joinPoint.proceed();
        stopWatch.stop();
        reportToMonitorSystem(joinPoint.getSignature().toShortString(),stopWatch.getTotalTimeMillis());
        return retVal;
    }

    public void reportToMonitorSystem(String methodName,long expiredTime){
        logger.info("============33333333333333333=====================");
        logger.info("======method {} invoke,expired time:{}ms-----",methodName,expiredTime);
    }


}

