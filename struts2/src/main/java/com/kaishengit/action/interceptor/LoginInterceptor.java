package com.kaishengit.action.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Created by Administrator on 2016/8/3.
 */
public class LoginInterceptor extends AbstractInterceptor {


    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        ActionProxy actionProxy = invocation.getProxy();
        String namespace = actionProxy.getNamespace();
        String actionName = actionProxy.getActionName();
        String result = null;

        Map<String,Object> session = ActionContext.getContext().getSession();

        Long curr_time = System.currentTimeMillis();
        if(namespace.equals("/") && (actionName.equals("index") || actionName.equals("login"))){
            result = actionProxy.execute();
        }else{
            if(session.get("username") != null){
               result =  actionProxy.execute();
            }else{
//                TODO 解决 查看是返回是什么 错误 Input 未登录Login
                return "input";
            }
        }

        System.out.println("执行方法为 getMethod : "+ invocation.getProxy().getMethod());
        return result;
    }


}
