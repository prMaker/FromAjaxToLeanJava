package com.kaishengit.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 */
public class Borrow implements Serializable{


    private static final long serialVersionUID = -6070288824694667685L;
    private Integer id;
    private Integer bid;
    private Integer cid;
    private String btime;
    private Book book;
    private Card card;

//    public List<Card> getCardList() {
//        return cardList;
//    }
//
//    public void setCardList(List<Card> cardList) {
//        this.cardList = cardList;
//    }
//
//    private List<Card> cardList;

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", bid=" + bid +
                ", cid=" + cid +
                ", btime='" + btime + '\'' +
                ", book=" + book +
                ", card=" + card +
//                ", cardList=" + cardList() +
                '}';
    }

//    private String cardList() {
//        String toString = "";
//        for (Card card : cardList) {
//            toString += card.toString()+"----";
//        }
//        return toString;
//    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }
}
