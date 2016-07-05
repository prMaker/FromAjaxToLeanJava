package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/5.
 */
public class BookType implements Serializable {

    private static final long serialVersionUID = 2622899132071159193L;

    private Integer id;
    private String booktype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }
}
