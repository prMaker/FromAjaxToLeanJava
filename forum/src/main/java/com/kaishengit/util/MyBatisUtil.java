package com.kaishengit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2016/6/29.
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory = sqlSessionFactory();


    private static SqlSessionFactory sqlSessionFactory() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return sessionFactory;
        } catch (IOException e) {
            throw new RuntimeException("读取配置文件异常",e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
