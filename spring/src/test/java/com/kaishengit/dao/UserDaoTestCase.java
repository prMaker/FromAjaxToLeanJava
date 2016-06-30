package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


        // 单例模式
        User user = User.getUser();


    }

}
