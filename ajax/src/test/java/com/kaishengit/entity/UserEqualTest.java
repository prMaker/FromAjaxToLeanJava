package com.kaishengit.entity;

import org.junit.Test;

/**
 * Created by Administrator on 2016/6/29.
 */
public class UserEqualTest {

    @Test
    public void EqualTest(){
        User user1 = new User(1,"Tom","User",87);
        User user2 = new User(1,"Tom","User",87);
        System.out.println(user1.equals(user2));

    }
}
