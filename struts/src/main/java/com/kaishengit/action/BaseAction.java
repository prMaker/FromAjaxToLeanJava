package com.kaishengit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/1.
 */
public abstract class BaseAction extends ActionSupport{

    private ActionContext actionContext;

    protected Map<String,Object> getSession(){
        return actionContext.getSession();
    }

    protected Map<String,Object> getApplication(){
        return actionContext.getApplication();
    }

    protected HttpServletRequest getServletRequest(){
        return ServletActionContext.getRequest();
    }

    protected HttpServletResponse getServletResponse(){
        return ServletActionContext.getResponse();
    }

    protected HttpSession getHttpSession(){
        return getServletRequest().getSession();
    }


}
