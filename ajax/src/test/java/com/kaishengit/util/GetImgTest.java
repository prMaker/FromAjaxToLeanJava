package com.kaishengit.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/22.
 */
public class GetImgTest {

    Logger logger = LoggerFactory.getLogger(GetImgTest.class);

    @Test
    public void getRequestImg() {

        for (int i = 1; i < 2; i++) {
            String url = "http://www.topit.me/pop?p=" + i;
            try {
                Document document = Jsoup.connect(url).cookie("is_click", "1").cookie("uauth","a4c4d1d0eb4a60c75daf53afcd216a9e%2B5603562").get();
                Elements elements = document.select(".catalog>.e");
                for (Element element : elements) {
                    System.out.println(111111);
                    String href = element.select("a").attr("href");
                    logger.debug("href:{}", href);
                    Document bigImgDoc = Jsoup.connect(href).cookie("is_click", "1").cookie("bdshare_firstime","1466524861447").get();
                    Element imgEle = bigImgDoc.select("#content>a").first();
                    String imgSrc = imgEle.attr("href");
                    String saveFile = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
                    HttpUtil.getRequestImg(imgSrc, saveFile);

                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException("3000请求服务器异常", e);
                }
            } catch (IOException e) {
                throw new RuntimeException("请求服务器异常", e);
            }
        }
    }
}
