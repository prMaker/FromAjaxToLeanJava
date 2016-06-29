package com.kaishengit.mapper;

import com.kaishengit.pojo.Borrow;
import com.kaishengit.util.IBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/28.
 */
public class BorrowMapperInterfaceTest {

    Logger logger = LoggerFactory.getLogger(BorrowMapper.class);

    @Test
    public void findByIdTest(){
        SqlSession sqlSession = IBatisUtil.getSqlSession();
        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
        Borrow borrow = borrowMapper.findById(15);
        logger.debug("{}",borrow);
        sqlSession.close();
    }


}
