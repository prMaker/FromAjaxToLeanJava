package com.kaishengit.dao;

/**
 * Created by Administrator on 2016/6/30.
 */
public class UserDaoImpl2 implements UserDao {
    @Override
    public Integer save() {
        System.out.println("UserDaoImpl2 : save");
//        if(1==1){
//            throw new RuntimeException("throwing Exception");
//        }
        return 5;
    }
}
