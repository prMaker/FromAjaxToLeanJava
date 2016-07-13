package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/7/13.
 */
public class Document implements Serializable{

    private static final long serialVersionUID = -579048096073767054L;
    private Integer id;
    private String name;
    private String size;
    private Timestamp createtime;
    private String createuser;
    private String type;
    private String filename;
    private String md5;
    private Integer fid;
    private String contenttype;

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", createtime=" + createtime +
                ", createuser='" + createuser + '\'' +
                ", type='" + type + '\'' +
                ", filename='" + filename + '\'' +
                ", md5='" + md5 + '\'' +
                ", fid=" + fid +
                '}';
    }
}
