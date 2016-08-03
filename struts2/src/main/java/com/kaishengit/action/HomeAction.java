package com.kaishengit.action;

/**
 * Created by Administrator on 2016/8/3.
 */
public class HomeAction extends BaseAction{

    private String username;
    private String password;

    public String loginView(){
        return SUCCESS;
    }

    public String login(){
        if("tom".equals(username) && "123".equals(password)){
            return SUCCESS;
        }
        return LOGIN;
    }


    @Override
    public String execute() throws Exception {
        return "success";
    }

    public String toLogin() throws Exception {
        return "success";
    }
}
