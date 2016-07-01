package com.kaishengit.dao;

/**
 * Created by Administrator on 2016/6/30.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public Integer save() {
        System.out.println("UserDaoImpl : save ");
        return 5;
    }
}
