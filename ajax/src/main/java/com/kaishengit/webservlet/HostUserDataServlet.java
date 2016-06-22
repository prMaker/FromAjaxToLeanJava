package com.kaishengit.webservlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@WebServlet("/hostuserdata")
public class HostUserDataServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(HostUserDataServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("11111");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String address = req.getParameter("address");
        String data = username +":"+ address;
        logger.debug(data);
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(data);
        printWriter.flush();
        printWriter.close();
    }
}
