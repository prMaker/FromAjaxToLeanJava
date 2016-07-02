package com.kaishengit.service;

import com.kaishengit.dao.LoginDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.pojo.Login;
import com.kaishengit.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Administrator on 2016/6/30.
 */
@Named
//@Transactional
public class UserService {


    @Inject
    private UserDao userDao;

//    public void setUserDao(UserDao userDao){
//        this.userDao = userDao;
//    }

//    public UserService(UserDao userDao){
//        this.userDao = userDao;
//    }


    public void save(User user){
        System.out.println("UserService :　save() ");
        userDao.save(user);
    }

//    @Transactional(readOnly = true)
    public User findById(Integer id){
        return userDao.findById(id);
    }

    @Inject
    private LoginDao loginDao;

//    @Transactional
    public User login(String name ,String password ,String ip) throws Exception {
        User user = userDao.findByName(name);
        if(user!=null && user.getPassword().equals(password)){
            Login login = new Login(ip,user.getId());
            loginDao.save(login);
            if(1==1){
                throw new ServiceException("service");
            }
        }else{
            throw new ServiceException("用户名密码错误");
        }

        return user;
    }
}
