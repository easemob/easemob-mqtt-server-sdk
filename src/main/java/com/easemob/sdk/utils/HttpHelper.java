package com.easemob.sdk.utils;

import com.easemob.sdk.exception.AccessDenyException;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.util.Timeout;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * HttoClient封装类
 *
 * @author vimin
 * @since 2021-08-11
 */
public class HttpHelper {
    public static String doGet(String url, Map<String, String> params, Map<String, String> headers) throws Exception {
        //创建一个可关闭的HttpClient
        try (final CloseableHttpClient httpClient = HttpClients.createDefault()) {
            //如果参数不为空，生成参数列表
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    nameValuePairs.add(new NameValuePair() {
                        @Override
                        public String getName() {
                            return entry.getKey();
                        }

                        @Override
                        public String getValue() {
                            return entry.getValue();
                        }
                    });
                }
            }
            //生成带参数的URI
            URI uri = new URIBuilder(url).setParameters(nameValuePairs).build();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(Timeout.of(10000, TimeUnit.MILLISECONDS))
                    .setConnectionRequestTimeout(Timeout.of(10000, TimeUnit.MILLISECONDS))
                    .build();
            //创建执行GET请求客户端
            final HttpGet httpGet = new HttpGet(uri);
            httpGet.setConfig(requestConfig);
            //如果headers不为空，填充header
            if (headers != null && headers.size() > 0) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpGet.setHeader(entry.getKey(), entry.getValue());
                }
            }
            //创建响应处理器
            try (final CloseableHttpResponse response = httpClient.execute(httpGet)) {
                //获取响应码
                final int statusCode = response.getCode();
                //判断响应码是否为成功
                if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {
                    //获取响应体
                    final HttpEntity entity = response.getEntity();
                    try {
                        //解析响应体，默认为utf-8编码
                        return entity != null ? EntityUtils.toString(entity, "utf-8") : null;
                    } catch (final ParseException ex) {
                        throw new ClientProtocolException(ex);
                    }
                } else {
                    final HttpEntity entity = response.getEntity();
                    //如果鉴权失败，抛出AccessDenyException异常
                    if (statusCode == 403) {
                        throw new AccessDenyException("request fail, status code is：" + statusCode + "，" + EntityUtils.toString(entity, "utf-8"));
                    }
                    //请求失败
                    return entity != null ? EntityUtils.toString(entity, "utf-8") : null;
//                    throw new ClientProtocolException("请求失败，响应码为：" + statusCode + "，" + EntityUtils.toString(response.getEntity(), "utf-8"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String doGet(String url) throws Exception {
        return doGet(url, null, null);
    }

    public static String doGet(String url, Map<String, String> params) throws Exception {
        return doGet(url, params, null);
    }

    public static String doPost(String url, Map<String, Object> params, Map<String, String> headers) throws Exception {
        // 创建一个可关闭的HttpClient
        try (final CloseableHttpClient httpClient = HttpClients.createDefault()) {
            final HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(Timeout.of(10000, TimeUnit.MILLISECONDS))
                    .setConnectionRequestTimeout(Timeout.of(10000, TimeUnit.MILLISECONDS))
                    .build();
            httpPost.setConfig(requestConfig);
            //设置请求体参数
            if (params != null) {
                StringEntity entity = new StringEntity(JsonUtils.toJson(params), Charset.forName("utf-8"));
                httpPost.setEntity(entity);
            }
            //设置请求头部
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }

            //请求响应
            try (final CloseableHttpResponse response = httpClient.execute(httpPost)) {
                //请求返回状态码
                int statusCode = response.getCode();
                //请求成功
                if (statusCode == HttpStatus.SC_OK && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {
                    //取出响应体
                    final HttpEntity entity2 = response.getEntity();
                    //返回响应体
                    return EntityUtils.toString(entity2);
                } else {
                    final HttpEntity entity = response.getEntity();
                    //如果鉴权失败，抛出AccessDenyException异常
                    if (statusCode == 403) {
                        throw new AccessDenyException("request fail, status code is：" + statusCode + "，" + EntityUtils.toString(entity, "utf-8"));
                    }
                    //请求失败
                    return entity != null ? EntityUtils.toString(entity, "utf-8") : null;
//                    throw new ClientProtocolException("请求失败，响应码为：" + statusCode + "，" + EntityUtils.toString(response.getEntity(), "utf-8"));
                }
            }
            //执行请求，返回请求响应
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String doPostJson(String url, Map<String, Object> params) throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return doPost(url, params, headers);
    }

    public static String doPostJson(String url, Map<String, Object> params, Map<String, String> headers) throws Exception {
        headers.put("Content-Type", "application/json");
        return doPost(url, params, headers);
    }
}
