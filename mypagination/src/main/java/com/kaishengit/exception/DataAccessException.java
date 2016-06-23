package com.kaishengit.exception;

import javax.servlet.http.HttpServlet;

/**
 * Created by Administrator on 2016/6/19.
 */
public class DataAccessException extends RuntimeException {

    public DataAccessException() {
    }

    public DataAccessException(String msg) {
        super(msg);
    }

    public DataAccessException(String msg, Exception e) {
        super(msg, e);
    }

}
