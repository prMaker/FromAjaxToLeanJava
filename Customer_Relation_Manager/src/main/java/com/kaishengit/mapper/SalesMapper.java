package com.kaishengit.mapper;

import com.kaishengit.pojo.Sales;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/15.
 */
public interface SalesMapper {

    Sales findAll();

    List<Sales> findAllByParam(Map<String,Object> param);

    void save(Sales sales);

    Sales findById(Integer id);

    void update(Sales sales);

    void delSales(Integer id);

    Long countByParam(Map<String, Object> param);
}
