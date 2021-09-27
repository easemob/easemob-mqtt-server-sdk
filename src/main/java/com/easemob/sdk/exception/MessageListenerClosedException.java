package com.easemob.sdk.exception;

/**
 * 如果消费者订阅主题时，线程已关闭，抛出异常
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-17
 */
public class MessageListenerClosedException extends Exception {
    public MessageListenerClosedException(String msg) {
        super(msg);
    }
}
