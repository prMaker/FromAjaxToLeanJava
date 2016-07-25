package com.kaishengit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class SpringRedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void setTest(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name:123","tom");
        System.out.println(valueOperations.get("name:123"));
    }

    @Test
    public void getTest(){
        System.out.println(redisTemplate.opsForValue().get("name:123"));
    }

    @Test
    public void incrTest(){
//        redisTemplate.opsForValue().set("num","123");
//        redisTemplate.opsForValue().increment("num",1L);
    }

}
