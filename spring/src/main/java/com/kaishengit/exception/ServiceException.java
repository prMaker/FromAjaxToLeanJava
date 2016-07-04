package com.kaishengit.exception;

/**
 * Created by Administrator on 2016/7/3.
 */
public class ServiceException extends RuntimeException {

    public ServiceException(){}

    public ServiceException(String msg){
        super(msg);
    }

}
