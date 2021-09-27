package com.easemob.sdk.exception;

/**
 * 鉴权失败异常
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-17
 */
public class AccessDenyException extends Exception {
    public AccessDenyException(String msg) {
        super(msg);
    }
}
