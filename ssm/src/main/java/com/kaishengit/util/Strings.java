package com.kaishengit.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Strings {

    public static String toUTF8(String str){
        try {
            return new String(str.getBytes("ISO8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
