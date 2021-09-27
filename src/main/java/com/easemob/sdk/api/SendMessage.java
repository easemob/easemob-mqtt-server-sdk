package com.easemob.sdk.api;

/**
 * SDK发消息
 */
public class SendMessage {
    /**
     * 主题名称数组
     */
    private String[] topics;

    /**
     * 客户端ID
     */
    private String clientid;

    /**
     * 消息体
     */
    private String payload;

    /**
     * 消息编码
     */
    private String encoding;

    /**
     * 是否保留消息，默认为0
     */
    private int retain = 0;
    /**
     * 消息最大保留时间
     */
    private Integer expire;

    /**
     * 消息qos等级
     */
    private int qos = 0;

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public int getRetain() {
        return retain;
    }

    public void setRetain(int retain) {
        this.retain = retain;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

}
