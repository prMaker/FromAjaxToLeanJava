package com.kaishengit.pojo;

import org.springframework.context.annotation.Scope;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/1.
 */
@Named
@Scope("prototype")
public class User implements Serializable{

    private Date date;
    private Integer id;
    private String name;
    private String password;

    public User(Date date, Integer id, String name, String password) {
        this.date = date;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "date=" + date +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
