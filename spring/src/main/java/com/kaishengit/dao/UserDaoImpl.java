package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
//@Service
@Named("userDao")
//@Scope("prototype")
//@Lazy(true)
//@Component
//@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql = "insert into `user` (`name`,password) values (?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getPassword());
    }

    @Override
    public void update(User user) {
        String sql = "update user set password=? where name=?";
        jdbcTemplate.update(sql,user.getPassword(),user.getName());
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User findById(Integer id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Long count() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql,new SingleColumnRowMapper<Long>());
    }

    @Override
    public User findByName(String name) {
        String sql = "select * from user where name = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),name);
    }


}
