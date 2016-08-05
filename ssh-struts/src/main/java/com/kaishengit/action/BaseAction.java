package com.kaishengit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/4.
 */
public class BaseAction extends ActionSupport {

    public Map<String,Object> getSession(){
        return ActionContext.getContext().getSession();
    }

    public Map<String,Object> getApplication(){
        return ActionContext.getContext().getApplication();
    }

    public HttpServletRequest getHttpServletRequest(){
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getHttpServletResponse(){
        return ServletActionContext.getResponse();
    }

    public HttpSession getHttpSession(){
        return getHttpServletRequest().getSession();
    }










}
