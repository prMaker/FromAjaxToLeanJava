package com.kaishengit.util;

import com.google.gson.Gson;
import com.kaishengit.entity.User;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/23.
 */
public class TestJsoup {

    private User user1 = new User(1,"Tom","China",95);
    private User user2 = new User(2,"Jack","USA",95);
    private User user3 = new User(3,"Lily","China",95);
    private User user4 = new User(4,"Lucy","UK",95);

    @Test
    public void testMap(){
        Map<String,Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("a",user1);
        stringObjectMap.put("b",user2);
        stringObjectMap.put("c",user3);
        Gson gson = new Gson();
        String str = gson.toJson(stringObjectMap);
        System.out.println(str);
    }

    @Test
    public void testList(){
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        String gson = new Gson().toJson(userList);
        System.out.println(gson);
    }
}
