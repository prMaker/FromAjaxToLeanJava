package com.kaishengit.util.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/27.
 */
public class EhcacheUtil {

    private static CacheManager cacheManager = new CacheManager();
    private static Logger logger = LoggerFactory.getLogger(EhcacheUtil.class);

    public static Object get(String key){
        Ehcache cache = cacheManager.getEhcache("myCache");
        Element element = cache.get(key);
        if(element != null){
            logger.debug("从ehcache中获取");
            return element.getObjectValue();
        }
        return  null;
    }

    public static void set(String key,Object object){
        Ehcache cache =  cacheManager.getEhcache("myCache");
        Element element = new Element(key,object);
        cache.put(element);
    }

    public static void remove(String key){
        Ehcache cache = cacheManager.getEhcache("myCache");
        cache.remove(key);
    }
}
