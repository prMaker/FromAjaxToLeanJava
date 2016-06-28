package com.kaishengit.util.cache;

import com.kaishengit.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MyCache {

    private static Map<String,Object> cache = new Hashtable<>();
    private static Logger logger = LoggerFactory.getLogger(MyCache.class);

    public static Object get(String key){
        if(cache.containsKey(key)){
            // 如果没有key的话返回什么
            logger.debug("从cache中获取");
            return cache.get(key);
        }
        return null;
    }

    public static void set(String key,Object object){
        cache.put(key,object);
    }

    public static void remove(String key){
        cache.remove(key);
    }
}
