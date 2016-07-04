package com.kaishengit.dao;

import com.kaishengit.exception.ServiceException;
import com.kaishengit.pojo.User;
import org.springframework.jdbc.core.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/2.
 */
@Named
public class UserDaoImpl implements UserDao {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql = "insert into user (name,password,address) values (?,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getPassword(),user.getAddress());

    }

    @Override
    public User findById(Integer id) {
        String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setAddress(resultSet.getString("address"));
                return user;
            }
        },id);
    }

    @Override
    public User findByName(String name) {
        String sql = "select * from user where name = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),name);
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public Long count() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql,new SingleColumnRowMapper<Long>());
    }

    @Override
    public void update(User user) {
        String sql = "update user set password = ? where name = ?";
        jdbcTemplate.update(sql,user.getPassword(),user.getName());
    }


}
