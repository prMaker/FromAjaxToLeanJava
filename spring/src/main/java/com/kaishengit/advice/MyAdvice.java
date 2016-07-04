package com.kaishengit.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import javax.inject.Named;

/**
 * Created by Administrator on 2016/7/2.
 */
@Named
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.kaishengit..*.*(..))")
    public void pointCut(){}

//    @Before("pointCut()")
//    public void beforeAdvice(){
//        System.out.println("前置通知");
//    }
//
//    @AfterReturning(pointcut = "pointCut()",returning = "result")
//    public void afterReturning(Object result){
//        System.out.println("后置通知"+result);
//    }
//
//    @AfterThrowing(pointcut = "pointCut()",throwing = "e")
//    public void throwing(Exception e){
//        System.out.println("异常通知"+e.getMessage());
//    }
//
//    @After("pointCut()")
//    public void after(){
//        System.out.println("最终通知");
//    }

    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint){
        Object object=null;
        try{
            System.out.println("前置通知");
            object = joinPoint.proceed();
            System.out.println("後置通知"+ object );
        }catch(Throwable throwable) {
            System.out.println("异常通知"+ throwable);
            throwable.printStackTrace();
        }finally{
            System.out.println("最终通知");
        }
        return object;
    }



}
