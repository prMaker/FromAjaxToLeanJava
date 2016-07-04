package com.kaishengit.service;

import com.kaishengit.dao.UserDao;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.pojo.User;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Administrator on 2016/7/3.
 */
@Named
public class UserService {

    @Inject
    private UserDao userDao;


    public void save(User user){
        userDao.save(user);

        if(1==1){
            throw new ServiceException("save()");
        }
    }

}
