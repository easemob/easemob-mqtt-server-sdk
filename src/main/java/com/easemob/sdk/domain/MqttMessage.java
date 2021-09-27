package com.easemob.sdk.domain;

import lombok.Data;

@Data
public class MqttMessage {
    /**
     * 连接ID
     */
    private String connid;
    /**
     * 消息收发时间戳
     */
    private String ts;
    /**
     * 消息ID
     */
    private String mid;
    /**
     * clientID，客户端ID
     */
    private String cid;
    private Integer pkt_id;
    /**
     * 状态
     */
    private String status;
    /**
     * 消息主题
     */
    private String topic;
    /**
     * 消息qos等级
     */
    private Integer qos;
    /**
     * 消息上行/下行，上行：uplink，下行：downlink
     */
    private String direction;
}