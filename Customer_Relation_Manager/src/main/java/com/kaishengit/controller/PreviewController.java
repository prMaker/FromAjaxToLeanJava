package com.kaishengit.controller;

import com.kaishengit.exception.NotFoundException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2016/7/12.
 */
@Controller
public class PreviewController {

    @Value("${imagePath}")
    private String filePath;

    @RequestMapping(value = "/preview/{fileName}")
    public void preview(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        File file = new File(filePath,fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        if(!file.exists()){
            throw new NotFoundException();
        }
        OutputStream outputStream = response.getOutputStream();

        IOUtils.copy(fileInputStream,outputStream);
        outputStream.flush();
        outputStream.close();
        fileInputStream.close();

    }

}
