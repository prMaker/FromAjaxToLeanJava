package com.kaishengit.mapper;

import com.kaishengit.pojo.SalesLog;

import java.util.List;

/**
 * Created by Administrator on 2016/7/16.
 */
public interface SalesLogMapper {

    void save(SalesLog salesLog);

    void delBySalesId(Integer id);

    List<SalesLog> findBySalesid(Integer saleId);
}
