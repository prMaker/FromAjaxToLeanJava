package com.kaishengit.mapper;

import com.kaishengit.pojo.Document;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public interface DocumentMapper {

    List<Document> findDocumentByFid(@Param("fid") Integer fid);

    void save(Document document);

    Document findDocumentById(Integer id);
}
