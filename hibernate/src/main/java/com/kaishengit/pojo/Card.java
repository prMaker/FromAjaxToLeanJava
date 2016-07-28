package com.kaishengit.pojo;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/7/26.
 */
@Entity
@Table(name = "t_card")
public class Card {

    @Id
    @GenericGenerator(name = "pk",strategy = "foreign",parameters = @org.hibernate.annotations.Parameter(name="property",value = "person"))
    @GeneratedValue(generator = "pk")
    private Integer id;
    private String cardname;
    @OneToOne(mappedBy = "card")
    @PrimaryKeyJoinColumn
    private Person person;

    public Card(String cardname) {
        this.cardname = cardname;
    }

    public Card() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardname='" + cardname + '\'' +
                ", person=" + person +
                '}';
    }
}
