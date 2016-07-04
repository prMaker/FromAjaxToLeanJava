package com.kaishengit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/7/4.
 */

@Controller
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showUserList(){
        logger.debug("{}","登入UserS网站");
        return "users";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId){
        logger.debug("{}登录网站",userId);
        return "users/show";
    }

    @RequestMapping(value = "/{userId}/photos/{photoId}",method = RequestMethod.GET)
    public String showUserPhoto(@PathVariable Integer userId,@PathVariable Integer photoId){
        logger.debug("{}用户{}照片显示",userId,photoId);
        return "users/photos";
    }

}
