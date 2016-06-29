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
public class IBatisUtil {

    private static SqlSessionFactory sqlSessionFactory = sqlSession();

    public static SqlSessionFactory sqlSession() {
        try {
            Reader reader = Resources.getResourceAsReader("ibatis.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return sessionFactory;
        } catch (IOException e) {
            throw new RuntimeException("",e);
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }


}
