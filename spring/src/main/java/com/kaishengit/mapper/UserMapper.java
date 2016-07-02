package com.kaishengit.mapper;

import com.kaishengit.pojo.User;

/**
 * Created by Administrator on 2016/7/2.
 */
public interface UserMapper {

    User findById(Integer id);

    void save(User user);
}
