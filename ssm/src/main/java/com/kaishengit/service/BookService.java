package com.kaishengit.service;

import com.kaishengit.mapper.BookMapper;
import com.kaishengit.mapper.BookTypeMapper;
import com.kaishengit.mapper.PublisherMapper;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

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

    public List<Book> list(){
        return bookMapper.findAll();
    }

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
}
