package com.kaishengit.pojo;

/**
 * Created by Administrator on 2016/6/27.
 */
public class User {
    private String date;
    private Integer id;
    private String name;
    private String password;
    private String address;

    public User() {
    }

    public User(String name, String password, String adress) {
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "date='" + date + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +

                ", password='" + password + '\'' +
                ", adress='" + address + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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


}
