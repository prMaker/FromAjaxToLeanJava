package com.kaishengit.action.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by Administrator on 2016/8/1.
 */
public class MyTimerInterceptor extends AbstractInterceptor{


    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        System.out.println(invocation.getProxy().getActionName()+" : actionname");
        System.out.println(invocation.getProxy().getAction()+" : action");
        System.out.println(invocation.getProxy().getMethod());

        Long curr_time = System.currentTimeMillis();

        invocation.getProxy().execute();
        Long curr_time_end = System.currentTimeMillis();

        System.out.println("方法用时："+(curr_time_end-curr_time)+"ms");

        return invocation.getProxy().execute();
    }
}
