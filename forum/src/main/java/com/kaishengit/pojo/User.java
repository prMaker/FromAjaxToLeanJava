package com.kaishengit.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/6/29.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 5115019539203978939L;
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String createtime;
    private String loginip;
    private String logintime;
    private String state;

    private List<Tag> tagList;

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createtime='" + createtime + '\'' +
                ", loginip='" + loginip + '\'' +
                ", logintime='" + logintime + '\'' +
                ", state='" + state + '\'' +
                ", tagList=" + tagList() +
                '}';
    }

    private String tagList() {
        String toString = "";
        System.out.println("大小"+tagList.size());
        for(Tag tag : tagList){
            toString += tag.toString() + "---";
        }

        return toString;
    }
}
