package com.kaishengit.pojo;

/**
 * Created by Administrator on 2016/6/30.
 */
public class User {

    //懒汉式
    
    private static User user;

    private User(){}

    public static User getUser(){
        if(user==null){
            user = new User();
        }
        return user;
    }


    // 饿汉式
//    private User(){
//        System.out.println("User");
//    }
//
//    private static User user = new User();
//
//    public static User getUser(){
//        System.out.println("getUser User");
//        return user;
//    }

}
