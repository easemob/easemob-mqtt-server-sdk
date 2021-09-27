package com.easemob.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfo {
    /**
     * 客户端唯一标识
     */
    private String clientID;
    /**
     * 在线状态
     */
    private String status;
    /**
     * 最新连接时间
     */
    private String time;
    /**
     * 当前登录使用的用户ID
     */
    private String user;
    /**
     * 心跳间隔
     */
    private int keepalive;
    /**
     * 是否清除会话
     */
    private boolean cleansession;
    /**
     * 遗嘱消息
     */
    private String will;
    /**
     * MQTT版本
     */
    private int version;
    /**
     * 订阅关系数组
     */
    private List<subscriber> dataobject = new ArrayList<>();
    /**
     * 订阅主题页面大小
     */
    private int pageSize;
    /**
     * 订阅主题当前页
     */
    private int currentPage;
    /**
     * 总条数
     */
    private int total;

    @Data
    public static class subscriber {

        public subscriber(String topic, int qos) {
            this.topic = topic;
            this.qos = qos;
        }

        /**
         * 订阅的主题名称
         */
        private String topic;
        /**
         * 设置的QoS等级
         */
        private int qos;
    }
}
