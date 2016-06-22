package com.kaishengit.webservlet;

import com.kaishengit.util.HttpUtil;

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

@WebServlet("/dict")
public class DictServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String word = new String(req.getParameter("word").getBytes("ISO8859-1"),"UTF-8");
        String url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=xml&version=1.1&q="+word;
        String xmlText = HttpUtil.getRequestText(url);
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(xmlText);
        printWriter.flush();
        printWriter.close();
    }
}
