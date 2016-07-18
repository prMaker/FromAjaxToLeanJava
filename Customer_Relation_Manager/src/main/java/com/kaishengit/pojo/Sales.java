package com.kaishengit.pojo;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
public class Sales implements Serializable {
    private static final long serialVersionUID = 5957309677514099312L;
    private static List<String> progressList = Lists.newArrayList();

    public static List<String> getProgressList(){
        progressList.add("初次接触");
        progressList.add("确认意向");
        progressList.add("提供合同");
        progressList.add("完成交易");
        progressList.add("交易搁置");
        return progressList;
    }

    private Integer id;
    private Integer userId;
    private String username;
    private Integer customerid;
    private String customername;
    private String name;
    private Float price;
    private String progress;
    private Timestamp createtime;
    private String lasttime;
    private String successtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public String getSuccesstime() {
        return successtime;
    }

    public void setSuccesstime(String successtime) {
        this.successtime = successtime;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", customerid=" + customerid +
                ", customername='" + customername + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", progress='" + progress + '\'' +
                ", createtime=" + createtime +
                ", lasttime='" + lasttime + '\'' +
                ", successtime='" + successtime + '\'' +
                '}';
    }
}
