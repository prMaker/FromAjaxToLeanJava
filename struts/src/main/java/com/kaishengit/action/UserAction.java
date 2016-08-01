package com.kaishengit.action;

import com.kaishengit.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/1.
 */
public class UserAction {

//    private String name;
//    private String address;

    private User user;
    private List<String> names;

    public UserAction() {
    }

    public String list(){
        names = new ArrayList<>();
        names.add("Tom");
        names.add("Jack");
        names.add("Lucy");
        return "success";
    }

    public String newUser(){

        System.out.println("name:" + user.getName() + " address:" + user.getAddress());
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
}
