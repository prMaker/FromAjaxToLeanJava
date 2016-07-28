package com.kaishengit.service;

import com.kaishengit.pojo.Card;
import com.kaishengit.pojo.Person;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Administrator on 2016/7/26.
 */
public class OneToOneTestCase {

    @Test
    public void saveTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Card card = new Card("信用卡");
        Person person = new Person("李师师");
        card.setPerson(person);

        session.save(person);
        session.save(card);

        session.getTransaction().commit();
    }

    @Test
    public void findPerson(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Person person = (Person) session.get(Person.class,14);
        System.out.println(person.getName());
        System.out.println(person.getName()+" : "+person.getCard().getCardname());

        session.getTransaction().commit();
    }

    @Test
    public void findCard(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Card card = (Card) session.get(Card.class,14);
        System.out.println(card.getCardname());
        System.out.println(card.getPerson().getName());

        session.getTransaction().commit();
    }

    @Test
    public void delteCard(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Card card = (Card) session.get(Card.class,12);
        session.delete(card);
        System.out.println(card.getCardname());
        System.out.println(card.getPerson().getName());

        session.getTransaction().commit();

    }
    @Test
    public void deltePerson(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Person person = (Person) session.get(Person.class,13);
        session.delete(person);

        session.getTransaction().commit();

    }









}
