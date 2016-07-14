package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/7/13.
 */
public class Customer implements Serializable{

    private static final long serialVersionUID = 8079486369524898977L;

    public static final String TYPE_PERSON = "person";
    public static final String TYPE_COMPANY = "company";

    private Integer id;
    private Integer userid;
    private String name;
    private String pinyin;
    private String tel;
    private String weixin;
    private String email;
    private String address;
    private Integer companyid;
    private String companyname;
    private Timestamp createtime;
    private String level;
    private String type;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", tel='" + tel + '\'' +
                ", weixin='" + weixin + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", companyid=" + companyid +
                ", companyname='" + companyname + '\'' +
                ", createtime=" + createtime +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
