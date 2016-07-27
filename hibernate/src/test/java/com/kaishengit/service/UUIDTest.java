package com.kaishengit.service;

import com.kaishengit.pojo.Task;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Administrator on 2016/7/27.
 */
public class UUIDTest {


    @Test
    public void uuidTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Task task = new Task("ksc",5);
        session.save(task);

        session.getTransaction().commit();
    }

    @Test
    public void findByid(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Task task = (Task) session.get(Task.class,"4028b881562afdcc01562afdd01a0000");
        System.out.println(task);
        // 清空一级缓存
//        session.clear();
        session.evict(task);
        session.getTransaction().commit();

        //清除二级缓存
//        Cache cache = HibernateUtil.getSessionFactory().getCache();
//        cache.evictAllRegions();
//        cache.evictEntityRegion(Task.class);
        // ===============================================================

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        Task task3 = (Task) session2.get(Task.class,"4028b881562afdcc01562afdd01a0000");
        System.out.println(task3);

        session2.getTransaction().commit();
    }
}
