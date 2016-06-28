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
 * Created by Administrator on 2016/6/24.
 */
@WebServlet("/dictjson.json")
public class DictJson extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        String url ="http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=json&version=1.1&q="+keyword;

        String json = HttpUtil.getRequestString(url);

        //设置格式
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(json);
        printWriter.flush();
        printWriter.close();

    }
}
