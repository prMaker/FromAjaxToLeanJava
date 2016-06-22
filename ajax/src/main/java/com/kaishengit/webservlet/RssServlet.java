package com.kaishengit.webservlet;

import com.kaishengit.uril.HttpUtil;

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
@WebServlet("/rss.xml")
public class RssServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = new String(req.getParameter("url").getBytes("ISO8859-1"), "UTF-8");
        String xml = HttpUtil.getRequestText(url);
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(xml);
        printWriter.flush();
        printWriter.close();
    }
}
