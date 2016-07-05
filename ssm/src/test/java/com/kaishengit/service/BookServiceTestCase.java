package com.kaishengit.service;

import com.kaishengit.pojo.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BookServiceTestCase {

    @Inject
    private BookService bookService;

    @Test
    public void saveTest(){
        Book book = new Book();
        book.setBookname("平凡的世界");
        book.setBookauthor("路遥");
        book.setBooknum(54);
        book.setBookprice(54.3F);
        book.setPubid(1);
        book.setTypeid(1);

        bookService.save(book);
    }

    @Test
    public void findAllTest(){

        List<Book> bookList = bookService.list();
        for(Book book : bookList){
            System.out.println(book);
            System.out.println(book.getPublisher().toString());
        }
        Assert.assertEquals(bookList.size(),30);
    }

    @Test
    public void delByIdTest(){
        bookService.delById(36);
    }

    @Test
    public void findById(){
        Book book = bookService.findById(35);
        Assert.assertNotNull(book);
    }

    @Test
    public void updateTest(){
        Book book = bookService.findById(30);
        book.setBooknum(10000);
        bookService.update(book);
    }
}
