package com.kaishengit.service;

import com.kaishengit.mapper.NoticeMapper;
import com.kaishengit.pojo.Notice;
import com.kaishengit.util.ShiroUtil;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/12.
 */
@Named
public class NoticeService {

    @Inject
    private NoticeMapper noticeMapper;

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
}
