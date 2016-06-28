package com.kaishengit.dao;

import com.kaishengit.entity.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MessageDaoTest {

    private MessageDao messageDao = new MessageDao();

    @Test
    public void findAllTest(){
        List<Message> messageList = messageDao.findAll();
        Assert.assertEquals(2,messageList.size());
    }

    @Test
    public void saveTest(){
        Message message = new Message("Jack","message4");
        messageDao.save(message);
    }
}
