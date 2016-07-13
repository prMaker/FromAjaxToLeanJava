package com.kaishengit.controller;

import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Document;
import com.kaishengit.service.DocumentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
@Controller
@RequestMapping("/doc")
public class DocumentController {

    @Inject
    private DocumentService documentService;
    @Value("${imagePath}")
    private String savePath;

    /**
     * 文档管理首页,文档目录fid选择页
     * @param model
     * @param fid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String doc(Model model,
                      @RequestParam(required = false,defaultValue = "0") Integer fid){

        List<Document> documentList = documentService.findDocumentByFid(fid);
        model.addAttribute("fid",fid);
        model.addAttribute("documentList",documentList);
        return "doc/list";
    }

    /**
     * 创建新文件夹
     * @param fid
     * @return
     */
    @RequestMapping(value = "/dir/new",method = RequestMethod.POST)
    public String createDir(Integer fid, String folderName, HttpServletResponse response){
        documentService.createNewDir(fid,folderName);
        return "redirect:/doc?fid="+fid;
    }

    /**
     * 根据id下载相应文件
     * @param id
     * @return
     */
    @RequestMapping(value = "/download/{id:\\d+}")
    public ResponseEntity<InputStreamResource> docDown(@PathVariable Integer id) throws FileNotFoundException, UnsupportedEncodingException {
        Document document = documentService.findDocumentById(id);
        if(document == null){
            throw new NotFoundException();
        }
        File file = new File(savePath,document.getName());
        if(!file.exists()){
            throw new NotFoundException();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        String fileName = document.getFilename();
        fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(document.getContenttype()))
                .contentLength(file.length())
                .header("Content-Disposition","attachment;filename=\""+fileName+"\"")
                .body(new InputStreamResource(fileInputStream));
    }

    /**
     * 保存上传的文件
     * @param file
     * @param fid
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(MultipartFile file, Integer fid) throws IOException {
        if(file.isEmpty()){
            throw new NotFoundException();
        }
        String fileName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        Long size = file.getSize();
        String contentType = file.getContentType();
        documentService.saveFile(inputStream,fileName,fid,size,contentType);
        return "success";
    }

    @RequestMapping(value = "/upper/{fid:\\d+}",method = RequestMethod.GET)
    public String upperStory(@PathVariable Integer fid){
        fid =documentService.findFidByid(fid);
        if(fid<0){
            throw new NotFoundException();
        }
        return "redirect:/doc?fid="+fid;
    }

}
