package com.kaishengit.service;

import com.kaishengit.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/7/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserServiceTest {

    @Inject
    private UserService userService;

    @Test
    public void findByIdTest(){
        System.out.println(userService.findById(21));
    }

    @Test
    public void saveTest(){
        User user = new User("李宗霖","1234567890");
        userService.save(user);
    }
}
