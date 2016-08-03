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
public class UserAction extends BaseAction {

    private List<String> names;
    private String username;
    private String password;
    private Map<String,Object> session = getSession();

    public UserAction() {}


    public String indexData(){
        return "success";
    }


    public String login(){
        if("tom".equals(username) && "123".equals(password)){
            session.put("username",username);
            return "success";
        }
        return "login";
    }


    public String list(){

        names = new ArrayList<>();
        names.add("Tom");
        names.add("Jack");
        names.add("Lucy");
        return "success";
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    get set


    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

}
