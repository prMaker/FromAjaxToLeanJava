package com.kaishengit.util;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/6/22.
 */
public class HttpUtil {

    public static String getRequestText(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int code = httpResponse.getStatusLine().getStatusCode();
            if(code == 200){
                InputStream inputStream = httpResponse.getEntity().getContent();
                return IOUtils.toString(inputStream);
            }else{
                throw new RuntimeException("请求服务器异常！");
            }
        } catch (IOException e) {
            throw new RuntimeException("请求服务器异常",e);
        }
    }

    public static void getRequestImg(String url,String saveFile){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int code = httpResponse.getStatusLine().getStatusCode();
            if(code == 200){
                InputStream inputStream = httpResponse.getEntity().getContent();
                FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
                IOUtils.copy(inputStream,fileOutputStream);

                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
            }else{
                throw new RuntimeException("请求服务器异常！");
            }

        } catch (IOException e) {
            throw new RuntimeException("服务器请求异常",e);
        }
    }

    public static String getRequestString(String url){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int status = httpResponse.getStatusLine().getStatusCode();
            if(status==200){
                InputStream inputStream = httpResponse.getEntity().getContent();
                return IOUtils.toString(inputStream);
            }else{
                throw new RuntimeException("请求服务器异常");
            }

        } catch (IOException e) {
            throw new RuntimeException("请求服务器异常",e);
        }


    }
}
