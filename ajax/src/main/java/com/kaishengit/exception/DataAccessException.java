package com.kaishengit.exception;

/**
 * Created by Administrator on 2016/6/8.
 */
public class DataAccessException extends RuntimeException{

    public DataAccessException(){}

    public DataAccessException(String msg){
        super(msg);
    }

    public DataAccessException(String msg,Exception e){
        super(msg,e);
    }

}
