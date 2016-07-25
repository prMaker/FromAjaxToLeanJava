package com.kaishengit.service;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Administrator on 2016/7/25.
 */
public class HibernateTestCase {

    @Test
    public void saveTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = new User("Tom","123456","USA");
        session.save(user);
        session.getTransaction().commit();
    }

    @Test
    public void getTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,42);
        System.out.println(user);
        session.getTransaction().commit();
    }

    @Test
    public void update(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,42);
        user.setAddress("北社");
        session.getTransaction().commit();

    }

    @Test
    public void delTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,43);
        session.delete(user);
        session.getTransaction().commit();
    }









}
