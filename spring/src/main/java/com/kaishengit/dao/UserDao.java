package com.kaishengit.dao;

import com.kaishengit.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2016/7/2.
 */
public interface UserDao {

    void save(User user);

    User findById(Integer id);

    User findByName(String name);

    List<User> findAll();

    Long count();

    void update(User user);
}
