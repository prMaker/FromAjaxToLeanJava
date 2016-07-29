package com.kaishengit.test2;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/7/28.
 */
public class Father<T,Pk> {


    public Father() {
        Class<?> clazz = this.getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        for(Type type : types){
            System.out.println(type);
        }
    }
}
