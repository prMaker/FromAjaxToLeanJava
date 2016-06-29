package com.kaishengit.util;

import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/29.
 */
public class UserMapperTest {

    private Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Test
    public void findByIdTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(10);
        logger.debug("{}",user);

        sqlSession.close();

        // _____------------------------------------

        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.findById(10);
        logger.debug("{}",user2);

        sqlSession2.close();

    }


}
