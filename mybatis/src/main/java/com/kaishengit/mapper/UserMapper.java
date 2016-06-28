package com.kaishengit.mapper;

import com.kaishengit.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface UserMapper {

    User findById(Integer id);

    void save(User user);

    List<User> findAll();

    void update(User user);

    void delete(Integer id);

    User findByMap(Map<String,Object> queryParam);

    User findByParams(@Param("username") String username,@Param("password") String passwrod);

    void batchSave(List<User> userList);

    List<User> findByIdList(List<Integer> idList);

    List<User> findByQueryParams(Map<String,Object> params);












}
