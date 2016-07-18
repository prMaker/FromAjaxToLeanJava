package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/7/15.
 */
public class SalesFile implements Serializable {
    private static final long serialVersionUID = 6041228244672567689L;

    private Integer id;
    private Integer salesid;
    private String filename;
    private String contenttype;
    private Long size;
    private Timestamp createtime;
    private String name;

    @Override
    public String toString() {
        return "SalesFile{" +
                "id=" + id +
                ", salesid=" + salesid +
                ", filename='" + filename + '\'' +
                ", contenttype='" + contenttype + '\'' +
                ", size=" + size +
                ", createtime=" + createtime +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
