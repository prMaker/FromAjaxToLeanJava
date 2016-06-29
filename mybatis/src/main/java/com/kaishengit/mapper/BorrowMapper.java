package com.kaishengit.mapper;

import com.kaishengit.pojo.Borrow;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface BorrowMapper {

    Borrow findById(Integer id);

    Borrow findByCid(Integer id);
}
