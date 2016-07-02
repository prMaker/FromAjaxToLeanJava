package com.kaishengit.dao;

import com.kaishengit.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
public interface UserDao{

    void save(User user);

    void update(User user);

    List<User> findAll();

    User findById(Integer id);

    void deleteById(Integer id);

    Long count();

    User findByName(String name);
}
