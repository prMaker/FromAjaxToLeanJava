package com.kaishengit.dao;

import com.kaishengit.pojo.Book;
import com.kaishengit.util.Page;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
@Named
public class BookDao extends BaseDao<Book,Integer>{
}
