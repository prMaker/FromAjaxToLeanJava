package com.kaishengit.service;

import com.kaishengit.dao.BookDao;
import com.kaishengit.dao.BookTypeDao;
import com.kaishengit.dao.PublisherDao;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import com.kaishengit.pojo.SearchParam;
import com.kaishengit.util.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
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
        return typeDao.findAll();
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
        bookDao.deleteById(id);
    }

    public Page<Book> findByPageNoByParam(Integer pageNo,List<SearchParam> searchParamList) {
//        Integer totalSize = bookDao.countByList(searchParamList).intValue();
//
//        Page<Book> bookPage = new Page<>(pageNo,5,totalSize);
//        List<Book> bookList = bookDao.findByPage(bookPage,searchParamList);
//        bookPage.setItems(bookList);
        return bookDao.findByPageNoByParam(pageNo,searchParamList);
    }

    public Page<Book> findByPageNo(Integer pageNo) {
        Integer totalSize = bookDao.countAll().intValue();

        Page<Book> bookPage = new Page<>(pageNo,5,totalSize);
        List<Book> bookList = bookDao.findByPage(bookPage);
        bookPage.setItems(bookList);
        return bookPage;
    }
}
