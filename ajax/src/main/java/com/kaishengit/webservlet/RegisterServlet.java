package com.kaishengit.webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/6/22.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = new String(req.getParameter("username").getBytes("ISO8859-1"),"UTF-8");
        System.out.println(username);
        PrintWriter printWriter = resp.getWriter();
        if("tom".equals(username)){
            printWriter.print("no");
        }else{
            printWriter.print("yes");
        }
        printWriter.flush();
        printWriter.close();
    }
}
