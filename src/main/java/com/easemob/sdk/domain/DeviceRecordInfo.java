package com.easemob.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 设备轨迹信息封装类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceRecordInfo {
    /**
     * 总条数
     */
    private int totalCount;
    /**
     * 设备记录列表
     */
    private List<MqttClientTrack> data;

    /**
     * 单条设备记录信息
     */
    @Data
    static class MqttClientTrack {
        private String connid;
        private String ts;
        private String status;
        private String reason;
        private String detail;
    }
}
