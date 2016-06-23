package com.kaishengit.util;

import com.kaishengit.entity.User;
import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/15.
 */
public class DbHelper {

    public void updateUser(String sql,Object...params){
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            queryRunner.update(sql,params);
        } catch (SQLException e) {
            throw new DataAccessException("执行"+sql+"异常",e);
        }
    }

    public <T> T queryUesr(String sql, ResultSetHandler<T> resultSetHandler, Object...params){
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            queryRunner.query(sql,resultSetHandler,params);
        } catch (SQLException e) {
            throw new DataAccessException("执行"+sql+"异常",e);
        }
    }

}
