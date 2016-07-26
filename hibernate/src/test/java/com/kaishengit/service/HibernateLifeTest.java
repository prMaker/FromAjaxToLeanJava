package com.kaishengit.service;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class HibernateLifeTest {

    @Test
    public void saveTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,5);
        System.out.println(user);
        session.getTransaction().commit();
    }

    @Test
    public void getTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,105);
        session.getTransaction().commit();
        Assert.assertNotNull(user);
    }

    @Test
    public void loadTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.load(User.class,105);

        System.out.println("Test Hiberate load");
        Assert.assertNotNull(user);
        System.out.println(user);
        session.getTransaction().commit();
    }



    @Test
    public void saveLifeTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

//        User user = new User("李宗霖","12456789","北社");
//        Integer id = (Integer) session.save(user);
//        System.out.println(id);

        User user = new User("Mrs Lizonglin","11111","北社");
        session.persist(user);

        session.getTransaction().commit();
    }

    @Test
    public void getAll(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "from User";
        Criteria criteria = session.createCriteria(User.class,hql);
        List<User> userList = criteria.list();

        for(User user : userList){
            System.out.println(user);
        }

        session.getTransaction().commit();
    }

    @Test
    public void update(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,5);
        System.out.println(user);
        user.setAddress("USA");
        user.setName("闪云风");
        session.update(user);

        session.getTransaction().commit();
    }

    @Test
    public void saveFreeStateTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.load(User.class,5);
        user.setName("Mrs Li");
        session.getTransaction().commit();

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        session2.update(user);

        session2.getTransaction().commit();

    }

    @Test
    public void save(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = new User();

        session.getTransaction().commit();
    }

    @Test
    public void saveOrUpdate(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.load(User.class,5);
        user.setName("Mrs Shanyunfeng");

        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

    @Test
    public void testMerge(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // 更新操作
//        User user = (User) session.load(User.class,5);
//
//        user.setName("Mrs Li");
//        session.merge(user);

        User user = new User("LiPing","99999","USA");
        session.merge(user);
        session.merge(user);

        session.getTransaction().commit();
    }

    @Test
    public void delete(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.load(User.class,45);
        session.delete(user);
        session.getTransaction().commit();

        System.out.println(user);

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        session2.merge(user);
        session2.getTransaction().commit();
    }

    @Test
    public void clear(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.load(User.class,56);
        user.setAddress("UK");

//        session.clear();
        user.setPassword("5464564646465");
        session.flush();
        session.getTransaction().commit();
    }

    @Test
    public void clearTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,56);
        System.out.println("begin");
        user.setAddress("USA");
        System.out.println("end");
        session.getTransaction().commit();
    }







}
