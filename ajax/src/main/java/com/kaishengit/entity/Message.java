package com.kaishengit.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/27.
 */
public class Message implements Serializable {

    private Integer id;
    private String author;
    private String message;

    public Message() {
    }

    public Message(String author, String message) {
        this.id = id;
        this.author = author;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
