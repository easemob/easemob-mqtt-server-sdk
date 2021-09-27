package com.easemob.sdk.exception;

/**
 * 启动客户端，如果没有注册监听器，会抛出异常
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-17
 */
public class NoMessageListenerRegisteredException extends Exception {
    public NoMessageListenerRegisteredException(String msg) {
        super(msg);
    }
}
