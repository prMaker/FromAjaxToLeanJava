package com.kaishengit.service;

import com.kaishengit.pojo.Topic;
import com.kaishengit.pojo.TopicContent;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Administrator on 2016/7/27.
 */
public class OneToOneTestCase2 {


    @Test
    public void saveTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Topic topic = new Topic("水晶");
        TopicContent topicContent = new TopicContent("蓝 白 红水晶");
        topic.setTopicContent(topicContent);

        session.save(topicContent);
        session.save(topic);

        session.getTransaction().commit();
    }


    @Test
    public void findTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Topic topic = (Topic) session.get(Topic.class,5);
        System.out.println(topic.getTitle());
        System.out.println(topic.getTopicContent().getContent());


        session.getTransaction().commit();
    }


}
