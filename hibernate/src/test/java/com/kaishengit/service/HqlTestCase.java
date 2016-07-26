package com.kaishengit.service;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.SQLCriterion;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class HqlTestCase {

    @Test
    public void hqlTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "from User";
        Criteria criteria = session.createCriteria(User.class,hql);
        List<User> userList = criteria.list();
        System.out.println(userList);
        for(User user : userList){
            System.out.println(user);
        }

        session.getTransaction().commit();
    }

    @Test
    public void criteriaTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "from User where name = :name and password=:password";
        Query query = session.createQuery(hql);
//        query.setString(0,"5");
        query.setParameter("name","李四");
        query.setParameter("password","123");
        List<User> userList = (List<User>) query.list();
        for(User user : userList){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }

    @Test
    public void findByColumn(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();


        // 单列查询
//        String hql = "select name from User";
//        Query query = session.createQuery(hql);
//        List<String> userList = query.list();
//
//        for(String user : userList){
//            System.out.println(user);
//        }

        //多列查询
        String hql = "select name,address from User";
        Query query = session.createQuery(hql);
        List<Object[]> objectList = query.list();
        for(Object[] objects : objectList){
            System.out.println(objects[0]+":"+objects[1]);
        }
        session.getTransaction().commit();
    }

    @Test
    public void countTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // 聚合函数使用
//        String hql = "select count(1) from User";
//        Query query = session.createQuery(hql);
//        Long count = (Long) query.uniqueResult();
//        System.out.println(count);

        String hql = "select count(1),max(id) from User";
        Query query = session.createQuery(hql);
        Object[] result = (Object[]) query.uniqueResult();

        System.out.println(result[0]+":"+result[1]);

        session.getTransaction().commit();
    }

    @Test
    public void pageTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "from User order by id desc";
        Query query = session.createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(5);
        List<User> userList = query.list();
        for(User user : userList){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }


    @Test
    public void distinct(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "select distinct name from User";
        Query query = session.createQuery(hql);
        List<String> result = query.list();
        for (String s : result){
            System.out.println(s);
        }

        session.getTransaction().commit();
    }







}
