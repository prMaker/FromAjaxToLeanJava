package com.kaishengit.service;

import com.kaishengit.mapper.TaskMapper;
import com.kaishengit.pojo.Task;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/18.
 */
@Named
public class TaskService {

    @Inject
    private TaskMapper taskMapper;
    private Logger logger = LoggerFactory.getLogger(TaskService.class);

    /**
     * 保存新的待办事项
     * @param task
     * @param hour
     * @param min
     */
    public void save(Task task, String hour, String min) {
        task.setUserid(ShiroUtil.getCurrentUserID());
        if(StringUtils.isNotEmpty(hour) && StringUtils.isNotEmpty(min)){
            task.setRemindertime(task.getStart() +" "+hour+":"+min+":00");
            logger.warn("时间：{}",task.getStart() +" "+hour+":"+min+":00");
        }
//        TODO 设置的时间为标准时间

        taskMapper.saveTask(task);
    }


    /**
     * 初始页信息加载
     * @param param
     * @return
     */
    public List<Task> findAllByParam(Map<String,Object> param) {
        param.put("userid",ShiroUtil.getCurrentUserID());
        return taskMapper.findAllByParam(param);
    }

    public void del(Integer id) {
        taskMapper.del(id);
    }

    /**
     *更新为已完成
     * @param id
     */
    @Transactional
    public void done(Integer id) {
        Task task = taskMapper.findById(id);
        task.setDone(true);
        taskMapper.update(task);
    }

    /**
     * 查找未完成事项
     * @return
     */
    public List<Task> findAllOutofTime() {
        String now = new DateTime().now().toString("YYYY-MM-dd");
        return taskMapper.findAllOutOfTime(now,ShiroUtil.getCurrentUserID());
    }

    /**
     * 为Sales添加待办
     * @return
     */
    public List<Task> findallBySalesid(Integer id) {
        return taskMapper.findAllBySalesid(id);
    }

    public Task findById(Integer id) {
        return taskMapper.findById(id);
    }
}
