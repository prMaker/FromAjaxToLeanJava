package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/19.
 */
public class Config {

    private static Properties properties = new Properties();

    static {

        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("Config.properties"));
        } catch (IOException e) {
            throw new DataAccessException("配置文件加载异常",e);
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

    public static String get(String key,String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

}
