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
@WebServlet("/userdata.xml")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        printWriter.print("<userdata>");
        printWriter.print("<user><username>Tom</username><address>USA</address><userage>19</userage></user>");
        printWriter.print("<user><username>Jack</username><address>UK</address><userage>19</userage></user>");
        printWriter.print("\n" +
                "\t<user><username>张三</username><address>China</address><userage>19</userage></user>");
        printWriter.print("<user><username>李四</username><address>china</address><userage>19</userage></user>");
        printWriter.print("</userdata>");
        printWriter.flush();
        printWriter.close();
    }
}
