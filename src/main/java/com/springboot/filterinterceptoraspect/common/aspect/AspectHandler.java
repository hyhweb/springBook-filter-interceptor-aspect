package com.springboot.filterinterceptoraspect.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;


@Aspect
@Component
public class AspectHandler {
    @Around("execution(* com.springboot.filterinterceptoraspect.controller.TestController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
    System.out.println("time aspect start");
    Object[] args = proceedingJoinPoint.getArgs();
    for (Object arg : args ) {
      System.out.println(arg.getClass().getName());
      System.out.println("arg is:"+arg);
    }
    long startTime = new Date().getTime();
    Object obj = proceedingJoinPoint.proceed();
    System.out.println("aspect 耗时：" + (new Date().getTime() - startTime));
    System.out.println("aspect end");
    return obj;
    }
}
