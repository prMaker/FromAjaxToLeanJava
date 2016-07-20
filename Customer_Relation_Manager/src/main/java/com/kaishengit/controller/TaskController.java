package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.JSONResult;
import com.kaishengit.pojo.Task;
import com.kaishengit.service.TaskService;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/18.
 */
@Controller
@RequestMapping("/task")
public class TaskController {


    @Inject
    private TaskService taskService;

    /**
     * 加载所有事项列表
     * 加载未完成列表
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        List<Task> taskList = taskService.findAllOutofTime();
        model.addAttribute("taskList",taskList);
        return "task/list";
    }

    @RequestMapping(value = "/load",method = RequestMethod.GET)
    @ResponseBody
    public List<Task> dataLoad(String start,String end){
        Map<String,Object> param = Maps.newHashMap();
        param.put("start",start);
        param.put("end",end);
        return taskService.findAllByParam(param);
    }

    /**
     * 保存新的待办事项
     * @param task
     * @param hour
     * @param min
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public JSONResult save(@RequestParam(required = false,defaultValue = "") Integer id,Task task, String hour, String min){
        if(!("").equals(id) && id != null ){
            task.setSalesid(id);
        }
        taskService.save(task,hour,min);
        return new JSONResult(task);
    }

    @RequestMapping(value = "/del/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public String del(@PathVariable Integer id){
        taskService.del(id);
        return "success";
    }

    @RequestMapping(value = "/done/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public String done(@PathVariable Integer id){
        taskService.done(id);
        return "success";
    }




















}
