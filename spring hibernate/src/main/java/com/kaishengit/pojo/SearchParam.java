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

    public static List<Object> builderSearchParam(HttpServletRequest request){
        Map<String,String> para = Maps.newHashMap();
        Enumeration<String> enumeration = request.getParameterNames();
        List<SearchParam> searchParamList = Lists.newArrayList();
        while(enumeration.hasMoreElements()){
            String param = enumeration.nextElement();
            SearchParam searchParam = new SearchParam();
            // TODO 进行测试1000
            para.put(param,request.getParameter(param));
//            TODO 注意非空判断
            if(param.startsWith("q_") && StringUtils.isNotEmpty(request.getParameter(param))){
                String[] params = param.split("_");
                if(params.length != 3){
                    throw new RuntimeException("请求Url参数出错："+param);
                }
                searchParam.setType(params[1]);
                searchParam.setPropertyname(params[2]);
                if(params[2].equals("bookname")){
//                    TODO 注意判断文字中文问题
                    searchParam.setValue(Strings.toUTF8(request.getParameter(param)));
                }else {
                    searchParam.setValue(new Float((request.getParameter(param))));
                }
                searchParamList.add(searchParam);
            }
        }
        List<Object> objectList = Lists.newArrayList();
        objectList.add(searchParamList);
        objectList.add(para);
        return objectList;

    }




















}
