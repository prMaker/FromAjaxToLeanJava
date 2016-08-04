package com.kaishengit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/3.
 */
public class UserAction extends BaseAction{

    // 保存使用
    private String name;
    private String pwd;
//    TODO 解决 code写到java中怎么出去 param ${code} code 有get和setter
    private String code;

//    TODO 解决 servlet中东西都为设置，不要get么？ 不适用getset直接设置使用
    private Map<String,Object> session;
    private Map<String,Object> application;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private HttpSession httpSession;

    public String newSave() throws Exception {


        System.out.println("name : "+ name);
        System.out.println("pwd : " + pwd);

        code="10002";
        return "success";
    }

    //    get set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }
}
