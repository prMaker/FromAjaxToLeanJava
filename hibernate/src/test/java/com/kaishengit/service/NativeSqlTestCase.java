package com.kaishengit.service;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class NativeSqlTestCase {

    @Test
    public void selectTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String sql = "select * from user";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        List<Object[]> result = sqlQuery.list();

        for (Object[] objects : result){
            System.out.println(objects[0]+":"+objects[1]+":"+objects[2]+":"+
                                objects[3]+":"+objects[4]);
        }
        session.getTransaction().commit();
    }

    @Test
    public void findById(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String sql = "select * from user where id = :id";

        SQLQuery sqlQuery = session.createSQLQuery(sql);
//        sqlQuery.setParameter(0,"5");
        sqlQuery.setParameter("id","5");

        Object[] objects = (Object[]) sqlQuery.uniqueResult();

        System.out.println(objects[0]+":"+objects[1]+":"+objects[2]+":"+
                objects[3]+":"+objects[4]);

        session.getTransaction().commit();
    }

    @Test
    public void findbyIdtoUser(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String sql = "select * from user where id = ?";
        SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(User.class);
        sqlQuery.setParameter(0,"5");
        User user = (User) sqlQuery.uniqueResult();
        System.out.println(user);


        session.getTransaction().commit();
    }









}
