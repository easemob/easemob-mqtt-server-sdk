package com.easemob.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * mqtt收发消息
 *
 * @author vimin
 * @since 2021-08-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MqttMessageInfo {
    private long totalCount;
    private List<MqttMessage> data;
}
