package com.kaishengit.util.cache;

import com.kaishengit.dao.MessageDao;
import com.kaishengit.entity.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MyCacheTest {

    MessageDao messageDao = new MessageDao();
    @Test
    public void getTest(){
        List<Message> messageList = messageDao.findAll();
        messageList = messageDao.findAll();
        messageList = messageDao.findAll();
        messageList = messageDao.findAll();
        messageList = messageDao.findAll();
        messageList = messageDao.findAll();
        Assert.assertNotNull(messageList);
    }

    @Test
    public void findByIdTest(){
        Message message = messageDao.findById(1);
        message = messageDao.findById(1);
        message = messageDao.findById(1);
        message = messageDao.findById(1);
        message = messageDao.findById(1);
        Assert.assertNotNull(message);
    }

    @Test
    public void getInJava (){
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
