package com.kaishengit.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Aop advice
 */
public class MyAdvice {


    public void beforeAdvice(){
        System.out.println("前置通知");
    }

    public void afterRuturningAdvice(Integer result){
        System.out.println("后置通知");
        System.out.println(result);
    }

    public void throwingAdvice(Exception e){
        System.out.println("异常通知");
        System.out.println(e);
    }

    public void afterAdive(){
        System.out.println("最终通知");
    }

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
