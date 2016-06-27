package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/9.
 */
public class DbHelp {

    private static Logger logger = LoggerFactory.getLogger(DbHelp.class);

    public static void updateUser(String sql,Object...params){
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            queryRunner.update(sql,params);
            logger.debug("执行{}成功",sql);
        } catch (SQLException e) {
            logger.debug("执行{}异常",sql);
            throw new DataAccessException("执行"+sql+"异常",e);
        }
    }

    public static <T> T queryUser(String sql , ResultSetHandler<T> rsh, Object...params) {
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
             T t = (T) queryRunner.query(sql, rsh, params);
            logger.debug("执行{}成功",sql);
            return t;
        } catch (SQLException e) {
            logger.debug("执行{}异常",sql);
            throw new DataAccessException("执行"+sql+"异常", e);
        }
    }
}
