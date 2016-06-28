package com.kaishengit.dao;

import com.kaishengit.entity.Message;
import com.kaishengit.util.DbHelp;
import com.kaishengit.util.cache.EhcacheUtil;
import com.kaishengit.util.cache.MyCache;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MessageDao {


    Logger logger = LoggerFactory.getLogger(MessageDao.class);
    public List<Message> findAll(){
        List<Message> messageList = (List<Message>) EhcacheUtil.get("messageList:1");
        if(messageList == null){
            String sql = "select * from t_message";
            messageList = DbHelp.queryUser(sql,new BeanListHandler<>(Message.class));
            EhcacheUtil.set("messageList:1",messageList);
        }
        return messageList;
    }

    public void save(Message message){
        String sql = "insert into t_message (author,message) values (?,?)";
        DbHelp.updateUser(sql,message.getAuthor(),message.getMessage());
        EhcacheUtil.remove("messageList:1");
        logger.debug("删除messageList：{}成功",sql);
    }

    public Message findById(Integer id){
        Message message = (Message) EhcacheUtil.get("message:1");
        if(message==null){
            String sql = "select * from t_message where id = ?";
            message = DbHelp.queryUser(sql,new BeanHandler<>(Message.class),1);
            EhcacheUtil.set("message:1",message);
        }
        return message;

    }
}
