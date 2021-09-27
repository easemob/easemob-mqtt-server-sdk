package com.easemob.sdk.utils;

import com.easemob.sdk.Client;
import com.easemob.sdk.Config;
import com.easemob.sdk.api.QueryMqttAppInfo;

/**
 * 应用级别的工具方法封装
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-26
 */
public class AppUtils {
    /**
     * 获取用户接入点地址
     *
     * @param appid
     * @param config
     * @return
     * @throws Exception
     */
    public static String getEndpoint(String appid, Config config) throws Exception {
        QueryMqttAppInfo queryMqttAppInfo = new QueryMqttAppInfo();
        queryMqttAppInfo.setAppid(appid);
        Client client = new Client(config);
        return client.queryMqttAppInfo(queryMqttAppInfo).getBody().getDomain();
    }
}
