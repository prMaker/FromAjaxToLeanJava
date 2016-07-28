package com.kaishengit.dao;

import com.kaishengit.pojo.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
@Named
public class BookDao {

    @Inject
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(Book book){
        getSession().saveOrUpdate(book);
    }

    public Book findById(Integer id){
        return (Book) getSession().get(Book.class,id);
    }

    public void delete(Integer id){
        getSession().delete(findById(id));
    }

    public List<Book> findAll(){
        return getSession().createCriteria(Book.class).addOrder(Order.desc("id")).list();
    }










}
