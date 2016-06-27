package com.kaishengit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MybatisUtil {

    private static SqlSession sqlSession = sqlSession();

    public static SqlSession sqlSession() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return sessionFactory.openSession();
        } catch (IOException e) {
            throw new RuntimeException("",e);
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSession;
    }


}
