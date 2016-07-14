package com.kaishengit.service;

import com.kaishengit.exception.NotFoundException;
import com.kaishengit.mapper.DocumentMapper;
import com.kaishengit.pojo.Document;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.print.Doc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/7/13.
 */
@Named
public class DocumentService {

    @Inject
    private DocumentMapper documentMapper;
    @Value("${imagePath}")
    private String savePath;

    public List<Document> findDocumentByFid(Integer fid) {
        return documentMapper.findDocumentByFid(fid);
    }

    public void createNewDir(Integer fid,String folderName) {

        Document document = new Document();
        document.setCreateuser(ShiroUtil.getCurrentUserRealname());
        document.setFid(fid);
        document.setFilename(folderName);
        document.setType("dir");

        documentMapper.save(document);
    }

    /**
     * 保存文件
     * @param inputStream
     * @param fileName
     * @param fid
     * @param size
     * @param contentType
     * @throws IOException
     */
    @Transactional
    public void saveFile(InputStream inputStream, String fileName, Integer fid, Long size, String contentType) {
        String name = "";
        if(fileName.lastIndexOf(".") != -1){
            String extname = fileName.substring(fileName.lastIndexOf("."));
            name = UUID.randomUUID().toString()+extname;
        }
//        String md5 = "";
        try {
//            md5 = DigestUtils.md5Hex(inputStream);
//            inputStream.reset();
            File file = new File(savePath,name);
            IOUtils.copy(inputStream,new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            throw new NotFoundException();
        }

        Document document = new Document();
        document.setType("doc");
        document.setFilename(fileName);
        document.setFid(fid);
        document.setCreateuser(ShiroUtil.getCurrentUserRealname());
        document.setSize(FileUtils.byteCountToDisplaySize(size));
        document.setName(name);
//        document.setMd5(md5);
//        TODO md5的计算与inputstream的reset
        document.setContenttype(contentType);
        documentMapper.save(document);


    }

    public Document findDocumentById(Integer id) {
        return documentMapper.findDocumentById(id);
    }

    public Integer findFidByid(Integer id) {
        return documentMapper.findDocumentById(id).getFid();
    }

    /**
     * 得到父ID的List集合负排序，方便进行导航
     * @param fid
     * @return
     */
    public List<Document> getFidList(Integer fid){

        List<Document> fidList = null;
        while (fid != 0){
            Document document = documentMapper.findDocumentById(fid);
            fid = document.getFid();
            fidList.add(document);
        }

        List<Document> fidListInversion = null;
        int length = fidList.size();
//        TODO 文档面包屑的制作
        for(int i = 0; i < length; i++){
            fidListInversion.add(fidList.get(length-i-1));
        }
        return fidListInversion;
    }

}
