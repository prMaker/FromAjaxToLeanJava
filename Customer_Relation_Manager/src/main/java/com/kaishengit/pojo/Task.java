package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/18.
 */
public class Task implements Serializable {

    private static final long serialVersionUID = -2274289187818274355L;

    private Integer id;
    private Integer custid;
    private Integer salesid;
    private Integer userid;
    private String title;
    private String start;
    private String end;
    private String color;
    private String remindertime;
    private Boolean done;

    @Override
    public String toString() {
        return "Tacsk{" +
                "id=" + id +
                ", custid=" + custid +
                ", salesid=" + salesid +
                ", userid=" + userid +
                ", title='" + title + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", color='" + color + '\'' +
                ", remindertime='" + remindertime + '\'' +
                ", done=" + done +
                '}';
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRemindertime() {
        return remindertime;
    }

    public void setRemindertime(String remindertime) {
        this.remindertime = remindertime;
    }
}
