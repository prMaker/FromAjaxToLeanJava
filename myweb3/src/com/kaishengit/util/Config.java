package com.kaishengit.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/15.
 */

/**
 * 读取配置文件
 *
 */
public class Config {

    private static Properties properties = new Properties();

    static{
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("加载配置文件config.properties异常",e);
        }
    }

    public static String get(String key){
        return (String) properties.get(key);
    }

    public static String get(String key,String defaultValue){
        return properties.getProperty(key,defaultValue);
    }

}
