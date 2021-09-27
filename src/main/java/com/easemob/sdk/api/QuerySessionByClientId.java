package com.easemob.sdk.api;

/**
 * 调用QuerySessionByClientId根据Client ID查询指定设备的连接信息。
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-11
 */
public class QuerySessionByClientId {
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

}
