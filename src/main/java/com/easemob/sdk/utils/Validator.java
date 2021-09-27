package com.easemob.sdk.utils;

import com.easemob.sdk.api.*;

/**
 * 参数校验器
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-18
 */
public class Validator {
    public static void validateParameters(ApplyTokenRequest applyTokenRequest) {
        if (StringUtils.isEmpty(applyTokenRequest.getUsername())) {
            throw new IllegalArgumentException("username can not be empty");
        }
        if (StringUtils.isEmpty(applyTokenRequest.getPassword())) {
            throw new IllegalArgumentException("password can not be empty");
        }
    }

    public static void validateParameters(QueryMqttRecordDevice queryMqttRecordDevice) {
        if (StringUtils.isEmpty(queryMqttRecordDevice.getClientid())) {
            throw new IllegalArgumentException("clientid can not be empty");
        }
        if (StringUtils.isEmpty(queryMqttRecordDevice.getBeginTime())) {
            throw new IllegalArgumentException("beginTime can not be empty");
        }
        if (StringUtils.isEmpty(queryMqttRecordDevice.getEndTime())) {
            throw new IllegalArgumentException("endTime can not be empty");
        }
    }

    public static void validateParameters(QueryMqttRecordMessageOfClient queryMqttRecordMessageOfClient) {
        if (StringUtils.isEmpty(queryMqttRecordMessageOfClient.getClientid())) {
            throw new IllegalArgumentException("clientid can not be empty");
        }
        if (StringUtils.isEmpty(queryMqttRecordMessageOfClient.getBeginTime())) {
            throw new IllegalArgumentException("beginTime can not be empty");
        }
        if (StringUtils.isEmpty(queryMqttRecordMessageOfClient.getEndTime())) {
            throw new IllegalArgumentException("endTime can not be empty");
        }
    }

    public static void validateParameters(QueryMqttRecordMessagePublish queryMqttRecordMessagePublish) {
        if (StringUtils.isEmpty(queryMqttRecordMessagePublish.getMessageid())) {
            throw new IllegalArgumentException("messageid can not be empty");
        }
        if (StringUtils.isEmpty(queryMqttRecordMessagePublish.getClientid())) {
            throw new IllegalArgumentException("clientid can not be empty");
        }
    }

    public static void validateParameters(QueryMqttRecordMessageSubscribe queryMqttRecordMessageSubscribe) {
        if (StringUtils.isEmpty(queryMqttRecordMessageSubscribe.getClientid())) {
            throw new IllegalArgumentException("clientid can not be empty");
        }
        if (StringUtils.isEmpty(queryMqttRecordMessageSubscribe.getMessageid())) {
            throw new IllegalArgumentException("messageid can not be empty");
        }
        if (StringUtils.isEmpty(queryMqttRecordMessageSubscribe.getBeginTime())) {
            throw new IllegalArgumentException("beginTime can not be empty");
        }
        if (StringUtils.isEmpty(queryMqttRecordMessageSubscribe.getEndTime())) {
            throw new IllegalArgumentException("endTime can not be empty");
        }
    }

    public static void validateParameters(QuerySessionByClientId querySessionByClientId) {
        if (StringUtils.isEmpty(querySessionByClientId.getClientid())) {
            throw new IllegalArgumentException("clientid can not be empty");
        }
    }

    public static void validateParameters(SendMessage sendMessage) {
        if (StringUtils.isEmpty(sendMessage.getClientid())) {
            throw new IllegalArgumentException("clientid can not be empty");
        }
        if (StringUtils.isNull(sendMessage.getPayload())) {
            throw new IllegalArgumentException("payload can not be empty");
        }
        if (sendMessage.getTopics() == null || sendMessage.getTopics().length == 0) {
            throw new IllegalArgumentException("topics can not be empty");
        }
    }

    public static void validateParameters(QueryMqttAppInfo queryMqttAppInfo) {
        if (StringUtils.isEmpty(queryMqttAppInfo.getAppid())) {
            throw new IllegalArgumentException("appid can not be empty");
        }
    }


}
