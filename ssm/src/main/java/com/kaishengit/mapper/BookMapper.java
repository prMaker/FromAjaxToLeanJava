package com.kaishengit.mapper;

import com.kaishengit.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/5.
 */
public interface BookMapper {

    void save(Book book);

//    两个参数必须@Param（"start"）
    List<Book> findAll(@Param("params") Map<String,Object> params);

    Book findById(Integer id);

    void delById(Integer id);

    void update(Book book);

    Long count(@Param("params") Map<String, Object> params);

<<<<<<< HEAD
    List<Book> findAllBook();

    List<Book> findBookByData(@Param("param") Map<String, Object> param);

    Long countByData(@Param("param") Map<String, Object> param);

    Long bookCount();
=======
    List<Book> findBookAll();
>>>>>>> master
}
