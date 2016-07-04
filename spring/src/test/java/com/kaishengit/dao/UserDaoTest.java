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
 * Created by Administrator on 2016/7/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserDaoTest {

    @Inject
    private UserService userService;

    @Test
    public void saveTest(){
        User user = new User("李宗霖","521","勋章");
        userService.save(user);

    }

//    @Test
//    public void findByIdTest(){
//        System.out.println(userDao.findById(28));
//    }
//
//    @Test
//    public void findByNameTest(){
//        System.out.println(userDao.findByName("李宗霖"));
//    }
//
//    @Test
//    public void findAllTest(){
//        List<User> userList = userDao.findAll();
//        for(User user : userList){
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void updateTest(){
//        User user = userDao.findById(27);
//        user.setPassword("521521521");
//        userDao.update(user);
//    }
//
//    @Test
//    public void countTest(){
//        System.out.println(userDao.count());
//    }

}
