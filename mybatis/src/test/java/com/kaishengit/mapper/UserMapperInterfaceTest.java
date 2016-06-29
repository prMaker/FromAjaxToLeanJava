package com.kaishengit.mapper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kaishengit.pojo.User;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/28.
 */
public class UserMapperInterfaceTest {

    private Logger logger = LoggerFactory.getLogger(UserMapperInterfaceTest.class);

    @Test
    public void findByIdTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(1);
        logger.debug("{}", user);
        sqlSession.close();

        // --------------------------------------------------

        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.findById(1);
        logger.debug("{}", user2);
        sqlSession2.close();
    }

    @Test
    public void saveTest() {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName("张三");
        user.setAddress("USA");
        user.setPassword("123456789");

        userMapper.save(user);
        logger.debug("{}", user);
        logger.debug("id -> {}", user.getId());
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void findAllTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        Assert.assertEquals(12, userList.size());

        sqlSession.close();
    }

    @Test
    public void updateTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(14);
        user.setName("李四");
        user.setPassword("123456789");
        userMapper.update(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delete(13);
        logger.debug("删除成功");

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findByMapTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> userMap = Maps.newHashMap();
        userMap.put("username", "Lucy");
        userMap.put("password", "123");
        User user = userMapper.findByMap(userMap);
        logger.debug("{}", user);

        sqlSession.close();
    }

    @Test
    public void findByParamsTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findByParams("Jack", "123");
        logger.debug("{}", user);
        sqlSession.close();
    }

    @Test
    public void batchSaveTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = Lists.newArrayList();
        userList.add(new User("user1", "123"));
        userList.add(new User("user2", "123"));
        userList.add(new User("user3", "123"));
        userMapper.batchSave(userList);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findByIdListTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> idList = Lists.newArrayList(1, 2, 8, 10);
        List<User> userList = userMapper.findByIdList(idList);
        for (User user : userList) {
            logger.debug("{}", user);
        }

        sqlSession.close();
    }

    @Test
    public void findByQueryParams() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> params = Maps.newHashMap();
        params.put("password", "123");
        params.put("address", "UK");
        List<User> userList = userMapper.findByQueryParams(params);
        for (User user : userList) {
            logger.debug("{}", user);
        }
        sqlSession.close();
    }

    @Test
    public void findByQueryParamsChooseTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> mapList = Maps.newHashMap();
        mapList.put("name", "Jack");
        mapList.put("password", "456");
        mapList.put("address", "USA");

        List<User> userList = userMapper.findByQueryParamsChoose(mapList);
        for (User user : userList) {
            logger.debug("{}", user);
        }
        sqlSession.close();
    }

    @Test
    public void findByParamsPageTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findByParamsPage("0", "5");
        for (int i = 0; i < userList.size(); i++) {
            logger.debug("{}",userList.get(i));
        }
        sqlSession.close();

    }

}
