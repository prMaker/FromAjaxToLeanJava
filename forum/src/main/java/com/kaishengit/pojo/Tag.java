package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/29.
 */
public class Tag implements Serializable{

    private static final long serialVersionUID = -2190383289758877615L;
    private Integer id;
    private String tagname;
    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagname='" + tagname + '\'' +
                ", userid=" + userid +
                '}';
    }
}
