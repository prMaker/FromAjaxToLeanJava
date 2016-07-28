package com.kaishengit.dao;

import com.kaishengit.pojo.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
@Named
public class PublisherDao {

    @Inject
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    public List<Publisher> findAll() {
        return getSession().createCriteria(Publisher.class).list();
    }
}
