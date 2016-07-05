package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/5.
 */
public class Book implements Serializable{

    private static final long serialVersionUID = 3280816898329102869L;

    private Integer id;
    private String bookname;
    private Float bookprice;
    private String bookauthor;
    private Integer booknum;
    private Integer typeid;
    private Integer pubid;
    private String bookpic;


    private Publisher publisher;
    private BookType bookType;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Float getBookprice() {
        return bookprice;
    }

    public void setBookprice(Float bookprice) {
        this.bookprice = bookprice;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public Integer getBooknum() {
        return booknum;
    }

    public void setBooknum(Integer booknum) {
        this.booknum = booknum;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getPubid() {
        return pubid;
    }

    public void setPubid(Integer pubid) {
        this.pubid = pubid;
    }

    public String getBookpic() {
        return bookpic;
    }

    public void setBookpic(String bookpic) {
        this.bookpic = bookpic;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", bookprice=" + bookprice +
                ", bookauthor='" + bookauthor + '\'' +
                ", booknum=" + booknum +
                ", typeid=" + typeid +
                ", pubid=" + pubid +
                ", bookpic='" + bookpic + '\'' +
                ", publisher=" + publisher +
                ", bookType=" + bookType +
                '}';
    }
}
