package com.kaishengit.test2;


import com.google.common.collect.Sets;
import org.junit.*;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/28.
 */
public class FSTest {

    @org.junit.Test
    public void TestOne(){
        Son son = new Son();
    }

    @org.junit.Test
    public void setTest(){
        Set<Integer> set = Sets.newHashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        Iterator<Integer> integerIterator = set.iterator();
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
            System.out.println(integerIterator.next());
            System.out.println("21111111111111111111111111111");
        }

    }

    @org.junit.Test
    public void splitTest(){
        String split = "a.b.c.d";
        if (split.contains(".")){
            split.replace(".","_");
        }
        System.out.println(split);
        String[] strings = split.split("_");
    }


}
