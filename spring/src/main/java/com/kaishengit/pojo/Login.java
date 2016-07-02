package com.kaishengit.pojo;

import org.springframework.context.annotation.Scope;

import javax.inject.Named;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/7/2.
 */
@Named
@Scope("prototype")
public class Login implements Serializable {
    private static final long serialVersionUID = 2840473916265711607L;

    public Login() {
    }

    public Login(String ip, Integer userid) {
        this.ip = ip;
        this.userid = userid;
    }

    private Integer id;
    private String ip;
    private Integer userid;
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
