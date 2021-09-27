package com.easemob.sdk.api;

import com.easemob.sdk.domain.OrderParams;

/**
 * 调用QueryMqttTraceMessageOfClient查询指定设备的消息收发列表。
 */
public class QueryMqttRecordMessageOfClient {
    /**
     * 发送者的clientId，由“{deviceID}@{AppID}”组成，其中{deviceID}由用户自定
     * 义，{AppID}从console获取，长度不能超过64个字符
     */
    private String clientid;
    /**
     * 分页大小
     */
    private int pageSize = 10;
    /**
     * 当前页码
     */
    private int currentPage = 1;
    /**
     * 查询起始时间
     */
    private String beginTime;
    /**
     * 查询结束时间
     */
    private String endTime;
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
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

    public OrderParams getOrder() {
        return order;
    }

    public void setOrder(OrderParams order) {
        this.order = order;
    }

}
