package com.kaishengit.action.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by Administrator on 2016/8/3.
 */
public class LoginInterceptor extends AbstractInterceptor {


    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        System.out.println("execute : "+ invocation.getProxy().execute());
        System.out.println("getMethod : "+ invocation.getProxy().getMethod());

        return invocation.getProxy().getMethod();
    }


}
