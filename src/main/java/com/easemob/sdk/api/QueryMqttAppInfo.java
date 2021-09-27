package com.easemob.sdk.api;

/**
 * 查询应用信息
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-26
 */
public class QueryMqttAppInfo {
    /**
     * appID
     */
    private String appid;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
