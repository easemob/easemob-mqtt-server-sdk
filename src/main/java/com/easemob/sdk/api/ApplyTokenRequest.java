package com.easemob.sdk.api;

/**
 * 调用ApplyToken创建临时访问Token。
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-11
 */
public class ApplyTokenRequest {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
