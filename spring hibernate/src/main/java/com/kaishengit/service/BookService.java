package com.kaishengit.service;

import com.kaishengit.dao.BookDao;
import com.kaishengit.dao.BookTypeDao;
import com.kaishengit.dao.PublisherDao;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
@Named
@Transactional
public class BookService {

    @Inject
    private BookDao bookDao;
    @Inject
    private BookTypeDao typeDao;
    @Inject
    private PublisherDao publisherDao;


    public List<Book> findAllBook() {
        return bookDao.findAll();
    }

    public List<BookType> findAllType() {
        return typeDao.findALL();
    }

    public List<Publisher> findAllPublilsher() {
        return publisherDao.findAll();
    }

    public void save(Book book) {
        bookDao.saveOrUpdate(book);
    }

    public Book findBookById(Integer id) {
        return bookDao.findById(id);
    }

    public void deleteBookById(Integer id) {
        bookDao.delete(id);
    }
}
