package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/5.
 */
public class Publisher implements Serializable {

    private static final long serialVersionUID = -2918726873496326860L;

    private Integer id;
    private String pubname;

    public String getPubname() {
        return pubname;
    }

    public void setPubname(String pubname) {
        this.pubname = pubname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", pubname='" + pubname + '\'' +
                '}';
    }
}
