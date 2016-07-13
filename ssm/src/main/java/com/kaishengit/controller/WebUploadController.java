package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2016/7/13.
 */
@Controller
public class WebUploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String webUpload(){
        return "web";
    }

    @RequestMapping(value = "/upload/data",method = RequestMethod.POST)
    public void doPost(MultipartFile file){
        System.out.println(file.getName()+":"+file.getOriginalFilename());
    }

}
