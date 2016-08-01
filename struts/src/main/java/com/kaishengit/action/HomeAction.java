package com.kaishengit.action;

import com.opensymphony.xwork2.ActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/1.
 */
public class HomeAction extends BaseAction{

    private Map<String,Object> session;

    public String home(){
        session = ActionContext.getContext().getSession();
        session.put("hi","123456789");
        System.out.println("Hello!Struts2!");
        return "success";
    }

//    set get


    @Override
    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
