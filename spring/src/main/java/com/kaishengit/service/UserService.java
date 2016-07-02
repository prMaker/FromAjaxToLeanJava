package com.kaishengit.service;

import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Administrator on 2016/7/2.
 */
@Named
public class UserService {

    @Inject
    private UserMapper userMapper;

    public User findById(Integer id){
        return userMapper.findById(id);
    }

    public void save(User user){
        userMapper.save(user);
    }

}
