package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/7/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserDaoTestCase {

    @Inject
    private UserService userService;

    @Test
    public void loginTest() throws Exception {
        userService.login("Jack","123","123.123.123.123");
    }

    @Inject
    private UserDao userDao;

    @Test
    public void SaveTest(){
        User user = new User("Jack","123456");
        userDao.save(user);
    }

    @Test
    public void updateTest(){
        User user = new User("Jack","123");
        userDao.update(user);
    }

    @Test
    public void findAllTest(){
        List<User> userList = userDao.findAll();
        for(User user : userList){
            System.out.println(user);
        }
    }

    @Test
    public void findByIdTest(){
        User user = userService.findById(22);
        System.out.println(user);
    }

    @Test
    public void deleteById(){
        userDao.deleteById(23);
    }

    @Test
    public void countTest(){
        System.out.println(userDao.count());
    }

}
