package com.kaishengit.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/23.
 */
public class User {

    private Integer id;
    private String name;
    private String address;
    private Float score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        return score != null ? score.equals(user.score) : user.score == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    Logger logger = LoggerFactory.getLogger(User.class);

//    @Override
//    public boolean equals(Object object){
//        if(object == null){
//            logger.debug("错误：{}",1);
//            return false;
//        }
//        if(!(object instanceof User)){
//            logger.debug("错误：{}",2);
//            return false;
//        }
//        User temp = (User) object;
//        if(temp.id != this.id){
//            logger.debug("错误：{}",3);
//            return false;
//        }
//        if(!temp.name.equals(this.name)){
//            logger.debug("错误：{}",4);
//            return false;
//        }
//        if(!temp.address.equals(this.address)){
//            logger.debug("错误：{}",5);
//            return false;
//        }
//        if(temp.score != this.score){
//            logger.debug("错误：{} -- {}",temp.score,this.score);
//            return false;
//        }
//        return true;
//    }

    public User(Integer id, String name, String address, Float score) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.score = score;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
