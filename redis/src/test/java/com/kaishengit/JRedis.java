package com.kaishengit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public class JRedis {

    private Jedis jedis = null;

    @Before
    public void initStart(){
        jedis = new Jedis("192.168.56.1");
    }

    @After
    public void close(){
        if(jedis != null){
            jedis.close();
        }
    }

    @Test
    public void get() {
        jedis.set("name", "张三");
        System.out.println(jedis.get("name"));
    }

    @Test
    public void mset() {
        jedis.mset("name:11", "tom", "name:22", "jack");
        List<String> stringList = jedis.mget("name:11", "name:22");
        for (String st : stringList) {
            System.out.println(st);
        }
    }

    @Test
    public void exists(){
        Assert.assertEquals(true,jedis.exists("name:11"));
    }

    @Test
    public void incr(){
        jedis.set("product:1:price","56.5");
        jedis.incrByFloat("product:1:price",0.51F);
        System.out.println("incrbyfloat:"+jedis.get("product:1:price"));

        jedis.set("movieshow:1:num","50");
        jedis.incrBy("movieshow:1:num",100);
        System.out.println("incrby:"+jedis.get("movieshow:1:num"));

        jedis.decr("movieshow:1:num");
        System.out.println("decr:"+jedis.get("movieshow:1:num"));
    }

    @Test
    public void strlen(){
        Assert.assertEquals(6,jedis.strlen("name").intValue());
        System.out.println(jedis.strlen("name"));
    }

    @Test
    public void append(){
        System.out.println(jedis.append("name","疯"));
        System.out.println(jedis.get("name"));
    }

}
