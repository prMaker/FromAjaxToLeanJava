package com.kaishengit.mapper;

import com.kaishengit.pojo.Book;

import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */
public interface BookMapper {

    void save(Book book);

    List<Book> findAll();

    Book findById(Integer id);

    void delById(Integer id);

    void update(Book book);
}
