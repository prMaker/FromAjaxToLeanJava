package com.kaishengit.dao;

import com.kaishengit.pojo.BookType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
@Named
public class BookTypeDao {

    @Inject
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public List<BookType> findALL() {
        return getSession().createCriteria(BookType.class).list();
    }
}
