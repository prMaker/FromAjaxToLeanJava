package com.kaishengit.mapper;

import com.kaishengit.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User findByUsername(String username);

    void updateUser(User user);

    List<User> findUserByParam(@Param("keyword") String keyword, @Param("start") String start, @Param("length") String length);

    Long countUserTotal();

    Long countUserParam(@Param("keyword") String keyword);

    void save(User user);

    User findById(Integer id);
}
