package com.kaishengit.service;

import com.kaishengit.mapper.NoticeMapper;
import com.kaishengit.pojo.Notice;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2016/7/12.
 */
@Named
public class NoticeService {

    @Inject
    private NoticeMapper noticeMapper;
    @Value("${imagePath}")
    private String filePath;

    @Transactional
    public void save(Notice notice) {
        notice.setRealname(ShiroUtil.getCurrentUserRealname());
        notice.setUserid(ShiroUtil.getCurrentUserID());
        noticeMapper.save(notice);
    }

    public Notice findNoticeById(Integer id) {
        return noticeMapper.findNoticeById(id);
    }

    public List<Notice> findNoticeByParam(Map<String, Object> param) {
        return noticeMapper.findNoticeByParam(param);
    }

    public Long countNotice() {
        return noticeMapper.count();
    }

    public Long countByParam(Map<String, Object> param) {
        return noticeMapper.countByParam(param);
    }

    public String saveFile(InputStream inputStream, String originalFilename) throws IOException {
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString()+suffix;
        File file = new File(filePath,fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(inputStream,fileOutputStream);

        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();

        return "/preview/"+fileName;
    }
}
