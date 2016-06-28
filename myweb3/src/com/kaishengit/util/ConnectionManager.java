package com.kaishengit.util;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.jnlp.IntegrationService;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/15.
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
        dataSource.setMaxWaitMillis(Integer.parseInt(Config.get("jdbc.maxwaitmillis")));
        dataSource.setMaxIdle(Integer.parseInt(Config.get("jdbc.maxidle")));
        dataSource.setMinIdle(Integer.parseInt(Config.get("jdbc.minidle")));
    }

    public static BasicDataSource getDataSource(){
        return dataSource;
    }
}
