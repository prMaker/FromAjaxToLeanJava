package com.kaishengit.action;

import com.kaishengit.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/1.
 */
public class UserAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware,ServletContextAware,ApplicationAware{

//    private String name;
//    private String address;

    private User user;
    private List<String> names;
    private Map<String,Object> session;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private ServletContext servletContext;
    private Map<String,Object> application;

    public UserAction() {
    }

    public String list(){

        session.put("hello","Session");
        ServletContext servletContext = httpServletRequest.getServletContext();


        names = new ArrayList<>();
        names.add("Tom");
        names.add("Jack");
        names.add("Lucy");
        return "success";
    }

    public String newUser() throws UnsupportedEncodingException {
        System.out.println("name:" + user.getName() + " address:" + new String(user.getAddress().getBytes("ISO8859-1"),"UTF-8"));
       return "success";
    }

// TODO 乱码解决问题
    public String newData(){
        return "success";
    }

//    get set


    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        this.application = map;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
