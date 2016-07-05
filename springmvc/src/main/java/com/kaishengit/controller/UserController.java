package com.kaishengit.controller;

import com.kaishengit.pojo.User;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
    public ModelAndView showUser(@PathVariable("id") Integer userId){
        logger.debug("{}登录网站",userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/show");
        modelAndView.addObject("num","123456789");
        return modelAndView;
    }

    @RequestMapping(value = "/{userId}/photos/{photoId:\\d+}",method = RequestMethod.GET)
    public String showUserPhoto(@PathVariable Integer userId,@PathVariable Integer photoId){
        logger.debug("{}用户{}照片显示",userId,photoId);
        return "users/photos";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String userNew(Model model,
            @RequestHeader("User-Agent") String userAgent,
            @RequestParam(required = false,defaultValue = "false") String vip,
            @RequestParam(required = false,defaultValue = "false") String name,
            @CookieValue(value = "JSESSIONID",required = false,defaultValue = "") String sessionId

    ){
        model.addAttribute("num","123456789");
        logger.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        logger.debug("{}",userAgent);
        logger.debug("vip:{},name:{}",vip,name);
        logger.debug("session:{}",sessionId);
        return "users/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String userNew(User user
                          ){

        logger.debug("name: {} -> address: {}",user.getUsername(),user.getAddress());
        return "redirect:/users";
    }

    @RequestMapping(value = "/{id:\\d+}/del",method = RequestMethod.GET)
    public String userDel(@PathVariable Integer id){
        logger.debug("用户：{} 已被删除",id);
        return "redirect:/users";
    }



//    Ajax
    @RequestMapping(value = "/{id:\\d+}/userexist",method = RequestMethod.GET,
                    produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String userExist(@PathVariable Integer id){
        return "true";
    }

    @RequestMapping(value = "/{id:\\d+}/showuser",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public User showUserJson(){
        User user = new User();
        user.setUsername("Jack");
        user.setAddress("USA");
        return user;
    }


//    native Servlet
    @RequestMapping("/test")
    public String test(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session){
        ServletContext servletContext = session.getServletContext();
        session.setAttribute("curr_user","tom");
        return "users/new";
    }



//    fileupload

    @RequestMapping("/upload")
    public String fileUploadTest(){
        return "users/img";
    }


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String fileUpload(String filename, MultipartFile file){
        logger.debug("文件名字：{}",filename);
        logger.debug("原始文件名：{}",file.getOriginalFilename());
        logger.debug("文件大小：{}",file.getSize());
        logger.debug("文件类型：{}",file.getContentType());

        try {
            IOUtils.copy(file.getInputStream(),new FileOutputStream("D:/"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "users";
    }




}
