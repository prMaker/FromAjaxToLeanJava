package com.kaishengit.service;

import com.kaishengit.mapper.BookMapper;
import com.kaishengit.mapper.BookTypeMapper;
import com.kaishengit.mapper.PublisherMapper;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import com.kaishengit.util.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/5.
 */
@Named
@Transactional
public class BookService {

    @Inject
    private BookMapper bookMapper;
    @Inject
    private BookTypeMapper bookTypeMapper;
    @Inject
    private PublisherMapper publisherMapper;

    public void save(Book book){
        bookMapper.save(book);
    }

//    public List<Book> list(Integer start,Integer pageSize){
//        return bookMapper.findAll(start,pageSize);
//    }

    public Book findById(Integer id){
        return bookMapper.findById(id);
    }

    public void delById(Integer id){
        bookMapper.delById(id);
    }

    public void update(Book book){
        bookMapper.update(book);
    }

    public List<BookType> findAllBookTypes() {
        return bookTypeMapper.findAll();
    }

    public List<Publisher> findAllPublishers() {
        return publisherMapper.findAll();
    }


    public Page<Book> findBookPage(Integer pageNo, Map<String, Object> params){
        Integer totalSize = bookMapper.count(params).intValue();
        Page<Book> bookPage = new Page<>(pageNo,5,totalSize);
        params.put("start",bookPage.getStart());
        params.put("pageSize",bookPage.getPageSize());
        List<Book> bookList = bookMapper.findAll(params);
        bookPage.setItems(bookList);
        return bookPage;
    }
	
    public List<Book> findAllBook() {
        return bookMapper.findAllBook();
    }

    public List<Book> findBookByData(Map<String,Object> param) {
        return bookMapper.findBookByData(param);
    }

    public Long bookCountByData(Map<String, Object> param) {
        return bookMapper.countByData(param);
    }

    public Long bookCount() {
        return bookMapper.bookCount();
    }
}
