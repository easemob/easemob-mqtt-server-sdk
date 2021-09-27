package com.easemob.sdk.api;

/**
 * 调用QueryMqttTraceDevice分页查询微消息队列MQTT版客户端的设备轨迹。当设备的状态出现异常时，
 * 您可以通过该接口查询指定设备的连接历史，帮助您快速定位异常原因。
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-11
 */
public class QueryMqttRecordDevice {
    /**
     * 客户端ID
     */
    private String clientid;
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

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
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

}
