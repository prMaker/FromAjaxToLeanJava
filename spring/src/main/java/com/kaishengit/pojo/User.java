package com.kaishengit.pojo;

import org.springframework.context.annotation.Scope;

import javax.inject.Named;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/7/2.
 */
@Named
@Scope("prototype")
public class User {

    private Integer id;
    private Timestamp timestamp;
    private String name;
    private String password;
    private String address;

    public User() {
    }

    public User(String name, String password, String address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
