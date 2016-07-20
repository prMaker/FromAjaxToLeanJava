package com.kaishengit.mapper;

import com.kaishengit.pojo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/18.
 */
public interface TaskMapper {


    void saveTask(Task task);

    List<Task> findAllByParam(Map<String,Object> param);

    void del(Integer id);

    Task findById(Integer id);

    void update(Task task);

    List<Task> findAllOutOfTime(@Param("now") String now,@Param("id") Integer id);

    List<Task> findAllBySalesid(Integer id);

}
