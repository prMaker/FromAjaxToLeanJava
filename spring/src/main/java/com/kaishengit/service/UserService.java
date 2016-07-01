package com.kaishengit.service;

import com.kaishengit.dao.UserDao;

/**
 * Created by Administrator on 2016/6/30.
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

//    public UserService(UserDao userDao){
//        this.userDao = userDao;
//    }


    public void save(){
        System.out.println("UserService :　save() ");
        userDao.save();
    }
}
