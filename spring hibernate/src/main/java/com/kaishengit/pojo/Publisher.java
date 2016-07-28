package com.kaishengit.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/7/28.
 */
@Entity
@Table(name = "t_publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pubname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPubname() {
        return pubname;
    }

    public void setPubname(String pubname) {
        this.pubname = pubname;
    }
}
