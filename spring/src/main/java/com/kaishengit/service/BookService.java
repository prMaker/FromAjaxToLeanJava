package com.kaishengit.service;

import com.kaishengit.dao.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/30.
 */
public class BookService {


    private String bookName;
    private Integer bookCode;
    private List<String> lists;
    private Set<String> sets;
    private Map<String,Object> maps;
    private Properties properties;
    private UserDao userDao;


    public void show() {
        System.out.println( "BookService{" +
                "bookName='" + bookName + '\'' +
                ", bookCode=" + bookCode +
                ", lists=" + lists +
                ", sets=" + sets +
                ", maps=" + maps +
                ", properties=" + properties +
                ", userDao=" + userDao +
                '}');
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookCode(Integer bookCode) {
        this.bookCode = bookCode;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
