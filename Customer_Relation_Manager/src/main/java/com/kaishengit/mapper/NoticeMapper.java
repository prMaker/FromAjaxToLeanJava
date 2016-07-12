package com.kaishengit.mapper;

import com.kaishengit.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/12.
 */
public interface NoticeMapper {

    void save(Notice notice);

    Notice findNoticeById(Integer id);

    List<Notice> findNoticeByParam(Map<String, Object> param);

    Long count();

    Long countByParam(Map<String, Object> param);
}
