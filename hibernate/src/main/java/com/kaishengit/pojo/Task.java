package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/27.
 */
public class Task implements Serializable{

    private static final long serialVersionUID = -7867952892033335524L;
    private String id;
    private String title;
    private Integer version;

    public Task() {
    }

    public Task(String title, Integer version) {
        this.title = title;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", version=" + version +
                '}';
    }
}
