package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.dto.FlashMessage;
import com.kaishengit.dto.JSONResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Notice;
import com.kaishengit.service.NoticeService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/12.
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Inject
    private NoticeService noticeService;

    /**
     * 进入公告页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String notice(){
        return "notice/list";
    }

    /**
     * 跳转到新增公告页面
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String noticeNew(){
        return "notice/new";
    }

    /**
     * 发布新公告
     * @param notice
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String noticeNew(Notice notice, RedirectAttributes redirectAttributes){
        noticeService.save(notice);
        redirectAttributes.addFlashAttribute("message",new FlashMessage("成功发布公告！"));
        return "redirect:/notice";
    }

    /**
     * 返回公告的json数据
     * @param
     * @return
     */
    @RequestMapping(value = "/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult<Notice> noticeLoad( HttpServletRequest request){
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String keyWord = request.getParameter("search[value]");

        Map<String,Object> param = Maps.newHashMap();
        param.put("start",start);
        param.put("length",length);
        param.put("keyword",keyWord);

        List<Notice> noticeList = noticeService.findNoticeByParam(param);
        Long count = noticeService.countNotice();
        Long countByParam = noticeService.countByParam(param);
        for(Notice notice : noticeList){
            System.out.println(notice);
        }

        return new DataTablesResult<>(draw,noticeList,count,countByParam);
    }

    /**
     * 公告内容显示页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
    public String view(@PathVariable Integer id,Model model){
        Notice notice = noticeService.findNoticeById(id);
        if(notice == null){
            throw new NotFoundException();
        }
        model.addAttribute("notice",notice);
        return "notice/view";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> upload(MultipartFile file) throws IOException {
        Map<String,Object> result = Maps.newHashMap();
        if(!file.isEmpty()){
            String url = noticeService.saveFile(file.getInputStream(),file.getOriginalFilename());
            result.put("success",true);
            result.put("file_path",url);
        }else{
            result.put("success",false);
            result.put("msg","请选择文件");
        }
        return result;
    }

}
