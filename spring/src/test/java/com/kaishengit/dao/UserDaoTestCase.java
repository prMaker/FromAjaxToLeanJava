package com.kaishengit.dao;

import com.kaishengit.service.BookService;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.print.Book;

/**
 * Created by Administrator on 2016/6/30.
 */
public class UserDaoTestCase {

    private Logger logger = LoggerFactory.getLogger(UserDaoTestCase.class);

    @Test
    public void sayHelloTest(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }

    @Test
    public void bookServiceTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.show();
    }

}
