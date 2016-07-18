package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/7/15.
 */
public class SalesLog implements Serializable {
    private static final long serialVersionUID = -5348739379980313366L;
    public static final String TYPE_AUTO = "auto";
    public static final String TYPT_HAND = "hand";

    private Integer id;
    private Integer salesid;
    private String type;
    private String context;
    private Timestamp createtime;

    @Override
    public String toString() {
        return "SalesLog{" +
                "id=" + id +
                ", salesid=" + salesid +
                ", type='" + type + '\'' +
                ", context='" + context + '\'' +
                ", createtime=" + createtime +
                '}';
    }

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

    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
