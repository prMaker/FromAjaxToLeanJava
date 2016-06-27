package com.kaishengit;

import com.kaishengit.pojo.User;
import com.kaishengit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2016/6/27.
 */
public class UserMapperTestCase {


    Logger logger = LoggerFactory.getLogger(UserMapperTestCase.class);

    @Test
    public void mybatisTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        User user = sqlSession.selectOne("com.kaishengit.UserMapper.findById",1);
        logger.debug("{}",user);
        sqlSession.close();
    }


    @Test
    public void saveTest(){
        User user = new User("Jack","12345678","USA");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        sqlSession.insert("com.kaishengit.UserMapper.save",user);
        logger.debug("添加成功");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        User user = sqlSession.selectOne("com.kaishengit.UserMapper.findById",1);
        user.setName("admin");
        sqlSession.update("com.kaishengit.UserMapper.update",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findAllTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<User> userList = sqlSession.selectList("com.kaishengit.UserMapper.findAll");
        for(User user: userList){
            logger.debug("{}",user);
        }
        sqlSession.close();
    }

    @Test
    public void deleteTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        sqlSession.delete("com.kaishengit.UserMapper.delete",8);
        sqlSession.commit();
        sqlSession.close();
    }
}
