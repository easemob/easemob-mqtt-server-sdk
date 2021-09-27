package com.easemob.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发送消息返回的封装对象
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatInfo {
    /**
     * 发送的消息ID
     */
    private List<String> mids;
}
