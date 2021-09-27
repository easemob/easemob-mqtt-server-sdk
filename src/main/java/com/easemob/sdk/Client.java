package com.easemob.sdk;

import com.alibaba.fastjson.TypeReference;
import com.easemob.sdk.api.*;
import com.easemob.sdk.domain.*;
import com.easemob.sdk.dto.KeyValue;
import com.easemob.sdk.exception.AccessDenyException;
import com.easemob.sdk.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * SDK客户端类
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-11
 */
public class Client {
    private Logger logger = LoggerFactory.getLogger(Client.class);

    private Config config;
    /**
     * 设置配置类
     *
     * @param config
     */
    public Client(Config config) {
        this.config = config;
    }

    /**
     * 获取user Token
     * 当客户端向服务端发送认证请求时，服务端向环信MQTT消息云申请user token
     *
     * @param applyTokenRequest
     * @return
     */
    public ResponseOk<TokenInfo> applyToken(ApplyTokenRequest applyTokenRequest) throws Exception {
        Validator.validateParameters(applyTokenRequest);
        String token = TokenUtils.acquireTokenFromCache(config, false);
        String url = buildApplyTokenUrl();
        Map<String, Object> body = ModelUtils.buildMap(new KeyValue[]{new KeyValue("username", applyTokenRequest.getUsername()), new KeyValue("password", applyTokenRequest.getPassword()), new KeyValue("appClientId", config.getAppClientId())});
        Map<String, String> headers = ModelUtils.buildStrMap(new KeyValue[]{new KeyValue("Authorization", token), new KeyValue("Content-Type", "application/json")});
        String res = doPostAction(url, body, headers);
        ResponseOk<TokenInfo> responseOk = ModelUtils.buildModel(res, new TypeReference<ResponseOk<TokenInfo>>() {
        });
        return responseOk;
    }


    /**
     * 查询设备记录
     *
     * @param queryMqttRecordDevice
     * @return
     * @throws Exception
     */
    public ResponseOk<DeviceRecordInfo> queryMqttRecordDevice(QueryMqttRecordDevice queryMqttRecordDevice) throws Exception {
        Validator.validateParameters(queryMqttRecordDevice);
        String token = TokenUtils.acquireTokenFromCache(config, false);
        String url = buildQueryMqttRecordDeviceUrl();
        KeyValue[] keyValues = new KeyValue[]{new KeyValue("clientid", queryMqttRecordDevice.getClientid()), new KeyValue("beginTime", queryMqttRecordDevice.getBeginTime()), new KeyValue("endTime", queryMqttRecordDevice.getEndTime()), new KeyValue("currentPage", queryMqttRecordDevice.getCurrentPage()), new KeyValue("pageSize", queryMqttRecordDevice.getPageSize())};
        Map<String, String> params = ModelUtils.buildStrMap(keyValues);
        KeyValue[] HKV = new KeyValue[]{new KeyValue("Authorization", token), new KeyValue("Content-Type", "application/json")};
        Map<String, String> headers = ModelUtils.buildStrMap(HKV);
        String res = doGetAction(url, params, headers);
        ResponseOk<DeviceRecordInfo> responseOk = ModelUtils.buildModel(res, new TypeReference<ResponseOk<DeviceRecordInfo>>() {
        });
        return responseOk;
    }


    /**
     * 查询客户端消息记录
     *
     * @param queryMqttRecordMessageOfClient
     * @return
     * @throws Exception
     */
    public ResponseOk<MqttMessageInfo> queryMqttRecordMessageOfClient(QueryMqttRecordMessageOfClient queryMqttRecordMessageOfClient) throws Exception {
        Validator.validateParameters(queryMqttRecordMessageOfClient);
        String token = TokenUtils.acquireTokenFromCache(config, false);
        String url = buildQueryMqttRecordMessageOfClientUrl();
        KeyValue[] keyValues = new KeyValue[]{new KeyValue("clientid", queryMqttRecordMessageOfClient.getClientid()), new KeyValue("pageSize", queryMqttRecordMessageOfClient.getPageSize()), new KeyValue("currentPage", queryMqttRecordMessageOfClient.getCurrentPage()), new KeyValue("beginTime", queryMqttRecordMessageOfClient.getBeginTime()), new KeyValue("endTime", queryMqttRecordMessageOfClient.getEndTime()), new KeyValue("order", queryMqttRecordMessageOfClient.getOrder().value())};
        Map<String, String> params = ModelUtils.buildStrMap(keyValues);
        KeyValue[] HKV = new KeyValue[]{new KeyValue("Authorization", token), new KeyValue("Content-Type", "application/json")};
        Map<String, String> headers = ModelUtils.buildStrMap(HKV);
        String res = doGetAction(url, params, headers);
        ResponseOk<MqttMessageInfo> responseOk = ModelUtils.buildModel(res, new TypeReference<ResponseOk<MqttMessageInfo>>() {
        });
        return responseOk;
    }


    /**
     * 查询消息发布信息
     *
     * @param queryMqttRecordMessagePublish
     * @return
     * @throws Exception
     */
    public ResponseOk<MqttMessageInfo> queryMqttRecordMessagePublish(QueryMqttRecordMessagePublish queryMqttRecordMessagePublish) throws Exception {
        Validator.validateParameters(queryMqttRecordMessagePublish);
        String token = TokenUtils.acquireTokenFromCache(config, false);
        String url = buildQueryMqttRecordMessagePublishUrl();
        KeyValue[] keyValues = new KeyValue[]{new KeyValue("clientid", queryMqttRecordMessagePublish.getClientid()), new KeyValue("messageid", queryMqttRecordMessagePublish.getMessageid()), new KeyValue("order", queryMqttRecordMessagePublish.getOrder().value())};
        Map<String, String> params = ModelUtils.buildStrMap(keyValues);
        KeyValue[] HKV = new KeyValue[]{new KeyValue("Authorization", token), new KeyValue("Content-Type", "application/json")
        };
        Map<String, String> headers = ModelUtils.buildStrMap(HKV);
        String res = doGetAction(url, params, headers);
        ResponseOk<MqttMessageInfo> responseOk = ModelUtils.buildModel(res, new TypeReference<ResponseOk<MqttMessageInfo>>() {
        });
        return responseOk;
    }


    /**
     * 查询消息投递信息
     *
     * @param queryMqttRecordMessageSubscribe
     * @return
     * @throws Exception
     */
    public ResponseOk<MqttMessageInfo> queryMqttRecordMessageSubscribe(QueryMqttRecordMessageSubscribe queryMqttRecordMessageSubscribe) throws Exception {
        Validator.validateParameters(queryMqttRecordMessageSubscribe);
        String token = TokenUtils.acquireTokenFromCache(config, false);
        String url = buildQueryMqttRecordMessageSubscribeUrl();
        KeyValue[] keyValues = new KeyValue[]{new KeyValue("clientid", queryMqttRecordMessageSubscribe.getClientid()), new KeyValue("messageid", queryMqttRecordMessageSubscribe.getMessageid()), new KeyValue("beginTime", queryMqttRecordMessageSubscribe.getBeginTime()), new KeyValue("endTime", queryMqttRecordMessageSubscribe.getEndTime()), new KeyValue("currentPage", queryMqttRecordMessageSubscribe.getCurrentPage()), new KeyValue("pageSize", queryMqttRecordMessageSubscribe.getPageSize()), new KeyValue("order", queryMqttRecordMessageSubscribe.getOrder().value())};
        Map<String, String> params = ModelUtils.buildStrMap(keyValues);
        KeyValue[] HKV = new KeyValue[]{new KeyValue("Authorization", token), new KeyValue("Content-Type", "application/json")};
        Map<String, String> headers = ModelUtils.buildStrMap(HKV);
        String res = doGetAction(url, params, headers);
        ResponseOk<MqttMessageInfo> responseOk = ModelUtils.buildModel(res, new TypeReference<ResponseOk<MqttMessageInfo>>() {
        });
        return responseOk;
    }

    /**
     * 查客户端在线状态
     *
     * @param querySessionByClientId
     * @return
     * @throws Exception
     */
    public ResponseOk<ClientInfo> querySessionByClientId(QuerySessionByClientId querySessionByClientId) throws Exception {
        Validator.validateParameters(querySessionByClientId);
        String token = TokenUtils.acquireTokenFromCache(config, false);
        String url = buildQuerySessionByClientIdUrl();
        KeyValue[] keyValues = new KeyValue[]{new KeyValue("clientid", querySessionByClientId.getClientid()), new KeyValue("currentPage", querySessionByClientId.getCurrentPage()), new KeyValue("pageSize", querySessionByClientId.getPageSize())};
        Map<String, String> params = ModelUtils.buildStrMap(keyValues);
        KeyValue[] HKV = new KeyValue[]{new KeyValue("Authorization", token), new KeyValue("Content-Type", "application/json")};
        Map<String, String> headers = ModelUtils.buildStrMap(HKV);
        String res = doGetAction(url, params, headers);
        ResponseOk<ClientInfo> responseOk = ModelUtils.buildModel(res, new TypeReference<ResponseOk<ClientInfo>>() {
        });
        return responseOk;
    }

    /**
     * 发送消息
     *
     * @param sendMessage
     * @return
     * @throws Exception
     */
    public ResponseOk<ChatInfo> sendMessage(SendMessage sendMessage) throws Exception {
        Validator.validateParameters(sendMessage);
        String token = TokenUtils.acquireTokenFromCache(config, false);
        String url = this.buildSendMessageUrl();
        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new KeyValue("topics", sendMessage.getTopics()));
        keyValues.add(new KeyValue("clientid", sendMessage.getClientid()));
        keyValues.add(new KeyValue("payload", sendMessage.getPayload()));
        keyValues.add(new KeyValue("qos", sendMessage.getQos()));
        keyValues.add(new KeyValue("retain", sendMessage.getRetain()));
        if (StringUtils.isNotEmpty(sendMessage.getEncoding())) {
            keyValues.add(new KeyValue("encoding", sendMessage.getEncoding()));
        }
        if (null != sendMessage.getExpire()) {
            keyValues.add(new KeyValue("expire", sendMessage.getExpire()));
        }
        Map<String, Object> body = ModelUtils.buildMap(keyValues.toArray(new KeyValue[]{}));
        Map<String, String> headers = ModelUtils.buildStrMap(new KeyValue[]{new KeyValue("Authorization", token), new KeyValue("Content-Type", "application/json")});
        String res = doPostAction(url, body, headers);
        ResponseOk<ChatInfo> responseOk = ModelUtils.buildModel(res, new TypeReference<ResponseOk<ChatInfo>>() {
        });
        return responseOk;
    }

    /**
     * 查询应用信息
     *
     * @param queryMqttAppInfo
     * @return
     * @throws Exception
     */
    public ResponseOk<AppInfo> queryMqttAppInfo(QueryMqttAppInfo queryMqttAppInfo) throws Exception {
        Validator.validateParameters(queryMqttAppInfo);
        String token = TokenUtils.acquireTokenFromCache(config, false);
        String url = this.buildAppInfoUrl();
        KeyValue[] keyValues = new KeyValue[]{new KeyValue("appid", queryMqttAppInfo.getAppid())};
        Map<String, String> params = ModelUtils.buildStrMap(keyValues);
        KeyValue[] HKV = new KeyValue[]{new KeyValue("Authorization", token), new KeyValue("Content-Type", "application/json")};
        Map<String, String> headers = ModelUtils.buildStrMap(HKV);
        String res = doGetAction(url, params, headers);
        ResponseOk<AppInfo> responseOk = ModelUtils.buildModel(res, new TypeReference<ResponseOk<AppInfo>>() {
        });
        return responseOk;
    }

    private String buildAppInfoUrl() {
        return config.getRestApi() + "/openapi/rm/user/info";
    }


    private String buildApplyTokenUrl() {
        return config.getRestApi() + "/openapi/rm/user/token";
    }

    private String buildQueryMqttRecordDeviceUrl() {
        return config.getRestApi() + "/openapi/rm/device/record";
    }

    private String buildQueryMqttRecordMessageOfClientUrl() {
        return config.getRestApi() + "/openapi/rm/message/record";
    }

    private String buildQueryMqttRecordMessagePublishUrl() {
        return config.getRestApi() + "/openapi/rm/message/publish";
    }

    private String buildQueryMqttRecordMessageSubscribeUrl() {
        return config.getRestApi() + "/openapi/rm/message/subscribe";
    }

    private String buildQuerySessionByClientIdUrl() {
        return config.getRestApi() + "/openapi/rm/broker/clientInfo";
    }

    private String buildSendMessageUrl() {
        return config.getRestApi() + "/openapi/v1/rm/chat/publish";
    }

    /**
     * 做POST请求
     *
     * @param url     请求URL
     * @param body    请求体
     * @param headers 请求头部
     * @return
     * @throws Exception
     */
    private String doPostAction(String url, Map<String, Object> body, Map<String, String> headers) throws Exception {
        String res;
        try {
            //调用接口返回结果
            res = HttpHelper.doPost(url, body, headers);
        } catch (AccessDenyException e) {
            try {
                //如果鉴权失败，重新获取token，重试一次
                String token = TokenUtils.acquireTokenFromCache(config, true);
                //设置新的鉴权token
                headers.put("Authorization", token);
                res = HttpHelper.doPost(url, body, headers);
            } catch (AccessDenyException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        return res;
    }

    /**
     * 做GET请求
     *
     * @param url     请求URL
     * @param params  请求参数
     * @param headers 请求头部
     * @return
     * @throws Exception
     */
    private String doGetAction(String url, Map<String, String> params, Map<String, String> headers) throws Exception {
        String res;
        try {
            res = HttpHelper.doGet(url, params, headers);
        } catch (AccessDenyException e) {
            try {
                //鉴权失败，重新获取token
                String token = TokenUtils.acquireTokenFromCache(config, true);
                //设置新的鉴权token
                headers.put("Authorization", token);
                res = HttpHelper.doGet(url, params, headers);
            } catch (AccessDenyException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        return res;
    }

}