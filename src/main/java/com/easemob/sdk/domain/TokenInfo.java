package com.easemob.sdk.domain;

import lombok.Data;

/**
 * 获取到的token信息
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-11
 */
@Data
public class TokenInfo {
    /**
     * 获取到的token
     */
    private String access_token;
    private String application;
    /**
     * 过期时间
     */
    private Long expires_in;

    /**
     * token类型信息
     */
    private User user;

    @Data
    public static class User {
        /**
         * token类型
         */
        private String type;
        /**
         * 用户名
         */
        private String username;
        /**
         * 激活状态
         */
        private boolean activated;
    }
}
