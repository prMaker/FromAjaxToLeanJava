package com.kaishengit.action;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/3.
 */
public class HomeAction extends BaseAction{
    private String code;

    @Override
    public String execute() throws Exception {
        return "success";
    }

    // 登录使用
    private String username;
    private String password;
    // 没有具体类型的接口调方法报NULL POINTER EXCEPTION
    private List<String> names = Lists.newArrayList();


    //    TODO 解决 查看是否写完Session session 在struts中不需要get和set
    public String login(){

        names.add("Tom");
        names.add("Lucy");
        names.add("Jim");

        code = "10004";

        if("tom".equals(username) && "123".equals(password)){
            Map<String,Object> session = getSession();
            session.put("username",username);
            return SUCCESS;
        }

        return LOGIN;
    }


    // get set
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

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
