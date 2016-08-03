package com.kaishengit.action;

import java.util.Map;

/**
 * Created by Administrator on 2016/8/1.
 */
public class HomeAction extends BaseAction{

    private Map<String,Object> session = getSession();
    private String username;
    private String password;


    public String login(){
        if("tom".equals(username) && "123".equals(password)){
            return "success";
        }
        return LOGIN;
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
}
