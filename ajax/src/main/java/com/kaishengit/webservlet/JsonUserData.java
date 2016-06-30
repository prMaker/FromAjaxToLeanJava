package com.kaishengit.webservlet;

import com.google.gson.Gson;
import com.kaishengit.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/23.
 */

@WebServlet("/jsonuser.json")
//@WebServlet("/jsonuser.xml")
public class JsonUserData extends HttpServlet{

    private User user1 = new User(1,"Tom","China",95);
    private User user2 = new User(2,"Jack","USA",95);
    private User user3 = new User(3,"Lily","China",95);
    private User user4 = new User(4,"Lucy","UK",95);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("",e);
        }
        PrintWriter printWriter = resp.getWriter();
        if("tom".equals(username)){
            printWriter.print("no");
        }else{
            printWriter.print("yes");
        }
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 使用Gson来将对象转换为Json字符串
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(new Gson().toJson(userList));
        printWriter.flush();
        printWriter.close();


        //传输xml文件流
//        resp.setContentType("text/xml;charset=UTF-8");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//        printWriter.print("<users>");
//        printWriter.print("<user id=\"1\"><username>Tom</username><address>USA</address><userage>19</userage></user>" +
//                "<user id=\"2\"><username>Jack</username><address>UK</address><userage>19</userage></user>" +
//                "<user id=\"3\"><username>张三</username><address>China</address><userage>19</userage></user>" +
//                "<user id=\"4\"><username>李四</username><address>china</address><userage>19</userage></user>");
//        printWriter.print("</users>");
//        printWriter.flush();
//        printWriter.close();

    }
}
