package com.easemob.sdk.test;

import com.easemob.sdk.Client;
import com.easemob.sdk.Config;
import com.easemob.sdk.api.*;
import com.easemob.sdk.domain.*;
import com.easemob.sdk.utils.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class OpenApiTest {
    private static Config config;
    private static Client client;

    @BeforeAll
    public static void beforeAll() {
        config = new Config();
        config.setAppClientId("YZA63eVgbRHDS9-lmYwBje8t2w")
                .setAppClientSecret("YZA6BaXcq4l8LN8b6ej7sTXqaEdhBsg")
                .setRestApi("https://api.cn1.mqtt.chat/app/vwp0b0");
        client = new Client(config);
    }

    @Test
    public void applyTokenRequestTest() throws Exception {
        // 申请
        ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest();
        applyTokenRequest.setUsername("test");
        applyTokenRequest.setPassword("123");
        ResponseOk<TokenInfo> responseOk = client.applyToken(applyTokenRequest);
        assumeTrue(responseOk.getCode() == 200);
        assumeTrue(StringUtils.isNotEmpty(responseOk.getBody().getUser().getUsername()));
    }

    @Test
    public void queryMqttRecordDevice() throws Exception {
        QueryMqttRecordDevice queryMqttRecordDevice = new QueryMqttRecordDevice();
        queryMqttRecordDevice.setBeginTime("2021-08-10 15:00:00");
        queryMqttRecordDevice.setEndTime("2021-08-10 16:00:00");
        queryMqttRecordDevice.setCurrentPage(1);
        queryMqttRecordDevice.setPageSize(10);
        queryMqttRecordDevice.setClientid("deviceId1@vwp0b0");
        ResponseOk<DeviceRecordInfo> responseOk = client.queryMqttRecordDevice(queryMqttRecordDevice);
        assumeTrue(responseOk.getCode() == 200);
    }

    @Test
    public void queryMqttRecordMessageOfClientTest() throws Exception {
        QueryMqttRecordMessageOfClient queryMqttRecordMessageOfClient = new QueryMqttRecordMessageOfClient();
        queryMqttRecordMessageOfClient.setClientid("deviceId1@vwp0b0");
        queryMqttRecordMessageOfClient.setBeginTime("2021-08-10 15:00:00");
        queryMqttRecordMessageOfClient.setEndTime("2021-08-10 16:00:00");
        queryMqttRecordMessageOfClient.setCurrentPage(1);
        queryMqttRecordMessageOfClient.setPageSize(10);
        queryMqttRecordMessageOfClient.setOrder(OrderParams.desc);
        ResponseOk<MqttMessageInfo> responseOk = client.queryMqttRecordMessageOfClient(queryMqttRecordMessageOfClient);
        assumeTrue(responseOk.getCode() == 200);
    }

    @Test
    public void queryMqttRecordMessagePublishTest() throws Exception {
        QueryMqttRecordMessagePublish queryMqttRecordMessagePublish = new QueryMqttRecordMessagePublish();
        queryMqttRecordMessagePublish.setClientid("deviceId1@vwp0b0");
        queryMqttRecordMessagePublish.setMessageid("045B93CAB4002000");
        queryMqttRecordMessagePublish.setOrder(OrderParams.desc);
        ResponseOk<MqttMessageInfo> responseOk = client.queryMqttRecordMessagePublish(queryMqttRecordMessagePublish);
        assumeTrue(responseOk.getCode() == 200);
    }

    @Test
    public void queryMqttRecordMessageSubscribeTest() throws Exception {
        QueryMqttRecordMessageSubscribe queryMqttRecordMessageSubscribe = new QueryMqttRecordMessageSubscribe();
        queryMqttRecordMessageSubscribe.setClientid("deviceId1@vwp0b0");
        queryMqttRecordMessageSubscribe.setMessageid("045B93CAB4002000");
        queryMqttRecordMessageSubscribe.setBeginTime("2021-08-10 15:00:00");
        queryMqttRecordMessageSubscribe.setEndTime("2021-08-10 16:00:00");
        queryMqttRecordMessageSubscribe.setCurrentPage(1);
        queryMqttRecordMessageSubscribe.setPageSize(10);
        queryMqttRecordMessageSubscribe.setOrder(OrderParams.desc);
        ResponseOk<MqttMessageInfo> responseOk = client.queryMqttRecordMessageSubscribe(queryMqttRecordMessageSubscribe);
        assumeTrue(responseOk.getCode() == 200);
    }

    @Test
    public void querySessionByClientIdTest() throws Exception {
        QuerySessionByClientId querySessionByClientId = new QuerySessionByClientId();
        querySessionByClientId.setClientid("deviceId1@vwp0b0");
        querySessionByClientId.setCurrentPage(1);
        querySessionByClientId.setPageSize(10);
        ResponseOk<ClientInfo> responseOk = client.querySessionByClientId(querySessionByClientId);
        assumeTrue(responseOk.getCode() == 200);
    }

    @Test
    public void sendMessageTest() throws Exception {
        String[] topics = new String[]{"a"};
        SendMessage sendMessage = new SendMessage();
        sendMessage.setClientid("deviceId1@vwp0b0");
        sendMessage.setPayload("Hello World");
        sendMessage.setQos(1);
        sendMessage.setRetain(1);
        sendMessage.setTopics(topics);
        ResponseOk<ChatInfo> responseOk = client.sendMessage(sendMessage);
        assumeTrue(responseOk.getCode() == 200);
        assumeTrue(responseOk.getBody().getMids().size() == topics.length);
    }

}
