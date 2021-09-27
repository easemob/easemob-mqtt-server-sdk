package com.easemob.sdk.api;

import com.easemob.sdk.domain.OrderParams;

/**
 * 调用QueryMqttTraceMessageSubscribe查询指定消息的投递轨迹。当消息的收发不符合预期时，
 * 您可以通过该接口查看订阅该消息的客户端、消息的投递时间等详细信息，帮助您快速定位异常原因。
 *
 * @author vimin
 * @since 2021-08-11
 */
public class QueryMqttRecordMessageSubscribe {
    /**
     * 发送者的clientId，由“{deviceID}@{AppID}”组成，其中{deviceID}由用户自定
     * 义，{AppID}从console获取，长度不能超过64个字符
     */
    private String clientid;
    /**
     * 消息ID
     */
    private String messageid;
    /**
     * 查询起始时间
     */
    private String beginTime;
    /**
     * 查询结束时间
     */
    private String endTime;
    /**
     * 当前页码
     */
    private int currentPage = 1;
    /**
     * 分页大小
     */
    private int pageSize = 10;
    /**
     * ASC升序，DESC降序
     */
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

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public OrderParams getOrder() {
        return order;
    }

    public void setOrder(OrderParams order) {
        this.order = order;
    }

}
