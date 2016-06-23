package com.kaishengit.exception;

import javax.xml.crypto.Data;

/**
 * Created by Administrator on 2016/6/15.
 */

/**
 * DataAccessException RuntimeException
 * @author prmaker
 */

public class DataAccessException extends RuntimeException {

    public DataAccessException(){
        super();
    }

    public DataAccessException(String msg){
        super(msg);
    }

    public DataAccessException(String msg,Exception e){
        super(msg,e);
    }

}
