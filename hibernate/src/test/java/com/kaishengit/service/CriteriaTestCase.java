package com.kaishengit.service;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class CriteriaTestCase {

    @Test
    public void getTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List<User> userList = criteria.list();
        for(User user : userList){
            System.out.println(user);
        }

        session.getTransaction().commit();
    }


    @Test
    public void testUnique(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("name","Mrs Shanyunfeng"));
        User user = (User) criteria.uniqueResult();
        System.out.println(user);

        session.getTransaction().commit();
    }

    @Test
    public void findByWhere(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);

//        criteria.add(Restrictions.like("name","李", MatchMode.START));

//        criteria.add(Restrictions.in("name",new String[]{"李四","李宗霖","Tom"}));

//        criteria.add(Restrictions.or(Restrictions.eq("name","李宗霖"),
//                Restrictions.eq("name","李四")));

        Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.eq("name","李宗霖"));
        disjunction.add(Restrictions.eq("name","李四"));

        criteria.add(disjunction);

        List<User> userList = criteria.list();
        for(User user : userList){
            System.out.println(user);
        }

        session.getTransaction().commit();
    }

    /**
     * TODO like in or2 and 重做
     */
    @Test
    public void findByWhereTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);

        // where 中的And
//        criteria.add(Restrictions.eq("name","李宗霖"));
//        criteria.add(Restrictions.eq("address","北社"));

        // or
//        criteria.add(Restrictions.or(Restrictions.eq("name","李宗霖"),
//                                     Restrictions.eq("name","李四")));

        // or2
//        Disjunction disjunction = Restrictions.disjunction();
//        disjunction.add(Restrictions.eq("name","李宗霖"));
//        disjunction.add(Restrictions.eq("name","李四"));
//        criteria.add(disjunction);

        // like
//        criteria.add(Restrictions.like("name","李",MatchMode.START));

        //in
        criteria.add(Restrictions.in("name",new String[]{"李宗霖","李四"}));

        List<User> userList = (List<User>) criteria.list();

        for (User user : userList){
            System.out.println(user);
        }

        session.getTransaction().commit();
    }

    /**
     * TODO pageTest 重做
     */
    @Test
    public void pageTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.in("name",new String[]{"李四","李宗霖"}));
        criteria.addOrder(Order.desc("id"));

        criteria.setFirstResult(3);
        criteria.setMaxResults(3);
        List<User> userList = criteria.list();
        for(User user : userList){
            System.out.println(user);
        }

        session.getTransaction().commit();
    }

    /**
     *
     * TODO count重做
     */
    @Test
    public void countTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
//        criteria.setProjection(Projections.count("id"));
//        criteria.setProjection(Projections.rowCount());

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.rowCount());
        projectionList.add(Projections.max("id"));

        criteria.setProjection(projectionList);

//        Long count = (Long) criteria.uniqueResult();
//        System.out.println(count);

        Object[] result = (Object[]) criteria.uniqueResult();
        System.out.println("count:"+result[0]);
        System.out.println("MaxId:"+result[1]);


        session.getTransaction().commit();
    }











}
