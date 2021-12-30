package com.lol.webPageController;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClients;
import java.util.Map;

import java.io.*;
import java.net.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

        /**
         * 向指定的URL发送GET方法的请求
         * @param url    发送请求的URL
         * @param param  请求参数，请求参数应该是 name1=value1&name2=value2 的形式
         * @return       远程资源的响应结果
         */
        public static String sendGet(String url, String param) {
            String result = "";
            BufferedReader bufferedReader = null;
            try {
                //1、读取初始URL
                String urlNameString = url + param;
                //2、将url转变为URL类对象
                URL realUrl = new URL(urlNameString);

                //3、打开和URL之间的连接
                URLConnection connection = realUrl.openConnection();
                //4、设置通用的请求属性
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty("connection", "Keep-Alive");
                connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                //connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

                //5、建立实际的连接
                connection.connect();
                //获取所有响应头字段
                Map<String, List<String>> map = connection.getHeaderFields();
                //遍历所有的响应头字段
                for(String key : map.keySet()) {
                    System.out.println(key + "---->" + map.get(key));
                }

                //6、定义BufferedReader输入流来读取URL的响应内容 ，UTF-8是后续自己加的设置编码格式，也可以去掉这个参数
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
                String line = "";
                while(null != (line = bufferedReader.readLine())) {
                    result += line;
                }
//			int tmp;
//            while((tmp = bufferedReader.read()) != -1){
//                result += (char)tmp;
//            }

            }catch (Exception e) {
                // TODO: handle exception
                System.out.println("发送GET请求出现异常！！！"  + e);
                e.printStackTrace();
            }finally {        //使用finally块来关闭输入流
                try {
                    if(null != bufferedReader) {
                        bufferedReader.close();
                    }
                }catch (Exception e2) {
                    // TODO: handle exception
                    e2.printStackTrace();
                }
            }
            return result;
        }

    /**
     * @param url 接口地址
//     * @param headers 消息头
     * @param data 消息体
     * @return
     */
    public static String sendPost(String url, String data) {
        String response = null;
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                StringEntity stringentity = new StringEntity(data, ContentType.create("application/json", "UTF-8"));
                httppost.setEntity(stringentity);
                // 循环添加header
/*                Iterator headerIterator = headers.entrySet().iterator();
                while (headerIterator.hasNext()) {
                    Entry<String, String> elem = (Entry<String, String>) headerIterator.next();
                    httppost.addHeader(elem.getKey(), elem.getValue());
                }*/
                //发post请求
                httpresponse = httpclient.execute(httppost);
                //utf-8参数防止中文乱码
                response = EntityUtils.toString(httpresponse.getEntity(), "utf-8");
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 原生字符串发送put请求
     * @param url
//     * @param token
     * @param jsonStr
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String sendPut(String url, String jsonStr) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000).setConnectionRequestTimeout(35000).setSocketTimeout(60000).build();
        httpPut.setConfig(requestConfig);
        httpPut.setHeader("Content-type", "application/json");
        httpPut.setHeader("DataEncoding", "UTF-8");
//        httpPut.setHeader("token", token);

        CloseableHttpResponse httpResponse = null;
        try {

            StringEntity stringEntity = new StringEntity(jsonStr, ContentType.create("application/json", "UTF-8"));
            //httppost.setEntity(stringEntity);

            //httpPut.setEntity(new StringEntity(jsonStr));
            httpPut.setEntity(stringEntity);

            System.out.println(httpPut.getEntity().toString());

            //发送put请求
            httpResponse = httpClient.execute(httpPut);
            HttpEntity entity = httpResponse.getEntity();
            //utf-8参数防止中文乱码
            //httpResponse = EntityUtils.toString(httpResponse.getEntity(), "utf-8");

            String result = EntityUtils.toString(entity);
            return result;
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * 发送delete请求
     *
     * @param url
//     * @param token
     * @param jsonStr
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String sendDelete(String url, String jsonStr) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000).setConnectionRequestTimeout(35000).setSocketTimeout(60000).build();
        httpDelete.setConfig(requestConfig);
        httpDelete.setHeader("Content-type", "application/json");
        httpDelete.setHeader("DataEncoding", "UTF-8");
//        httpDelete.setHeader("token", token);

        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpDelete);
            HttpEntity entity = httpResponse.getEntity();
            String result = EntityUtils.toString(entity);
            return result;
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}
