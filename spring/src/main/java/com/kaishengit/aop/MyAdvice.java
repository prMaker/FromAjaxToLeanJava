package com.kaishengit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import javax.inject.Named;

/**
 * Aop advice
 */
@Named
@Aspect
public class MyAdvice {


    @Pointcut("execution(* com.kaishengit..*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void afterRuturningAdvice(Integer result){
        System.out.println("后置通知");
        System.out.println(result);
    }

    @AfterThrowing(pointcut ="pointCut()",throwing = "e")
    public void throwingAdvice(Exception e){
        System.out.println("异常通知");
        System.out.println(e);
    }

    @After("pointCut()")
    public void afterAdive(){
        System.out.println("最终通知");
    }

//    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint){
        Object object = null;
        try{
            System.out.println("前置通知~~~~~~~~");
            object = joinPoint.proceed();
            System.out.println("后置通知" + object);
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知~~~~~~");
        }
        return object;
    }

}
