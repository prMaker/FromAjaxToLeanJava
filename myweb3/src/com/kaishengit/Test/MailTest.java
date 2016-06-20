package com.kaishengit.Test;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;

/**
 * Created by Administrator on 2016/6/15.
 */
public class MailTest {

    @Test
    public void htmlEmailTest(){
        HtmlEmail htmlEmail = new HtmlEmail();

        htmlEmail.setHostName("smtp.163.com");
        htmlEmail.setAuthentication("prmaker","y1593812");
        htmlEmail.setSmtpPort(25);
        htmlEmail.setCharset("UTF-8");

        try {
            htmlEmail.setFrom("prmaker@163.com");
            htmlEmail.setSubject("明天8:00开会");
            htmlEmail.setHtmlMsg("<h1>明天8：00开会</h1><img src='http://s.img.mix.sina.com.cn/auto/resize?img=http%3A%2F%2Fwww.sinaimg.cn%2Fdy%2Fslidenews%2F1_simg%2F2016_23%2F94cf898780fa512d2b5f415ecb82b6b8.jpg&size=328_218' alt=''/>");
            htmlEmail.addTo("734520467@qq.com");
            htmlEmail.send();
        } catch (EmailException e) {
            throw new RuntimeException("发送邮件异常",e);
        }

    }

}
