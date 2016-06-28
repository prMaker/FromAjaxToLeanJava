package com.kaishengit.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/14.
 */
public class Config {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("Config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("读取文件Config.properties异常",e);
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

    public static String get(String key,String defaultValue){
        return properties.getProperty(key,defaultValue);
    }
}
