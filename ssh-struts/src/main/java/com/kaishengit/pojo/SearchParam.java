package com.kaishengit.pojo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kaishengit.util.Strings;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/28.
 */
public class SearchParam implements Serializable {

    private String type;
    private String propertyname;
    private Object value;

    public SearchParam() {
    }

    public SearchParam(String type, String propertyname, Object value) {
        this.type = type;
        this.propertyname = propertyname;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public static List<SearchParam> builderSearchParam(HttpServletRequest request){
        Enumeration<String> enumeration = request.getParameterNames();
        List<SearchParam> searchParamList = Lists.newArrayList();
        while(enumeration.hasMoreElements()){
            String param = enumeration.nextElement();
            SearchParam searchParam = null;

            Object value = request.getParameter(param);

//            TODO 注意非空判断  Object进行非空判断 先null 后  toString
            if(param.startsWith("q_") && value != null && StringUtils.isNotEmpty(value.toString())){
                String[] params = param.split("_",4);

                if(params.length != 4){
                    throw new RuntimeException("地址栏查询字符串格式错误：："+param);
                }

                String type = params[2];
                String valueType = params[1];
                String propertyname = params[3];
                value = converterType(value,valueType);

                searchParam = new SearchParam(type,propertyname,value);
                searchParamList.add(searchParam);

                request.setAttribute(param,value);
            }
        }
        return searchParamList;
    }

    private static Object converterType(Object param, String valueType) {

        if(valueType.equals("s")){
            return Strings.toUTF8(param.toString());
        }else if(valueType.equals("i")){
            return Integer.valueOf(param.toString());
        }else if(valueType.equals("f")){
            return Float.valueOf(param.toString());
        }else if(valueType.equals("d")){
            return Double.valueOf(param.toString());
        }else if(valueType.equals("b")){
            return Boolean.valueOf(param.toString());
        }else if(valueType.equals("c")){
            return Character.valueOf(param.toString().toCharArray()[0]);
        }


        return null;
    }


}
