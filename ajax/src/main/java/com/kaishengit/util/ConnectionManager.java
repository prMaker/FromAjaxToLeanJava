package com.kaishengit.util;


import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/8.
 */
public class ConnectionManager {


    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName(Config.get("jdbc.driver"));
        dataSource.setUrl(Config.get("jdbc.url"));
        dataSource.setUsername(Config.get("jdbc.username"));
        dataSource.setPassword(Config.get("jdbc.password"));

        dataSource.setInitialSize(Integer.parseInt(Config.get("jdbc.initsize")));
        dataSource.setMaxTotal(Integer.parseInt(Config.get("jdbc.maxsize")));
        dataSource.setMinIdle(Integer.parseInt(Config.get("jdbc.minidle")));
        dataSource.setMaxIdle(Integer.parseInt(Config.get("jdbc.maxidle")));
        dataSource.setMaxWaitMillis(new Long(Config.get("jdbc.waitmillis")));

    }

    public static BasicDataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("连接连接池异常",e);
        }
        return connection;
    }

    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataAccessException("数据库连接关闭异常",e);
        }
    }
}
