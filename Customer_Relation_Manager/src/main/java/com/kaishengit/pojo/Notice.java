package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/7/12.
 */
public class Notice implements Serializable {

    private static final long serialVersionUID = 5525071332313741919L;

    private Integer id;
    private Integer userid;
    private String title;
    private String context;
    private String realname;
    private Timestamp createtime;

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", userid=" + userid +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", realname='" + realname + '\'' +
                ", timestamp=" + createtime +
                '}';
    }
}
