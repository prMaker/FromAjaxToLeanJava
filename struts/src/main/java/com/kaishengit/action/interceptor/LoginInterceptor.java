package com.kaishengit.action.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by Administrator on 2016/8/1.
 */
public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        String actionName = invocation.getProxy().getActionName();
        String nameSpace = invocation.getProxy().getNamespace();
        String username = (String) ActionContext.getContext().getSession().get("username");

        if(nameSpace.equals("/") && (actionName.equals("index") || actionName.equals("login"))){
            return invocation.getProxy().execute();
        }else{
            if(username != null){
               return invocation.getProxy().execute();
            }
            return Action.LOGIN;
        }
    }


}
