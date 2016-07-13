package com.kaishengit.controller;

import com.kaishengit.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.*;

/**
 * Created by Administrator on 2016/7/12.
 */
@Controller
public class PreviewController {

    @Value("${imagePath}")
    private String filePath;

    @RequestMapping(value = "/preview/{fileName}")
    public ResponseEntity<InputStreamResource> preview(@PathVariable String fileName) throws IOException {
        File file = new File(filePath,fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        if(!file.exists()){
            throw new NotFoundException();
        }
//        OutputStream outputStream = response.getOutputStream();
//
//        IOUtils.copy(fileInputStream,outputStream);
//        outputStream.flush();
//        outputStream.close();
//        fileInputStream.close();

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(fileInputStream));
    }

}
