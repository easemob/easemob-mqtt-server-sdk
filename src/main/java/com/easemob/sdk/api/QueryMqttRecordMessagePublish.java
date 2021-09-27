package com.easemob.sdk.api;

import com.easemob.sdk.domain.OrderParams;
/**
 * 调用QueryMqttTraceMessagePublish查询指定消息的发送轨迹。当消息的收发不符合预期时，
 * 您可以通过该接口查看消息的发布时间、发布客户端等详细信息，帮助您快速定位异常原因。
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-11
 */
public class QueryMqttRecordMessagePublish {
    private String clientid;
    private String messageid;
    private OrderParams order = OrderParams.desc;

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public OrderParams getOrder() {
        return order;
    }

    public void setOrder(OrderParams order) {
        this.order = order;
    }

}
