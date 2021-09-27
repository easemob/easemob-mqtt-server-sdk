package com.easemob.sdk.utils;

import com.alibaba.fastjson.JSONObject;
import com.easemob.sdk.Client;
import com.easemob.sdk.Config;
import com.easemob.sdk.api.ApplyTokenRequest;
import com.easemob.sdk.domain.ResponseOk;
import com.easemob.sdk.domain.TokenInfo;
import com.easemob.sdk.exception.AccessDenyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * token服务
 *
 * @author vimin
 * @since 2021-08-11
 */
public class TokenUtils {
    private static String token;
    private static Logger logger = LoggerFactory.getLogger(TokenUtils.class);

    /**
     * 从远程服务器获取token，并存入缓存
     *
     * @param config 配置参数
     * @return 申请的token
     * @throws Exception 当参数错误时，抛出异常
     * @author vimin
     * @since 2021-08-11
     */
    public static String applyAppToken(Config config) throws Exception {
        //拼接mqtt后台链接
        String url = config.getRestApi() + "/openapi/rm/app/token";
        //封装调用参数
        Map<String, Object> params = new HashMap<>();
        //设置app client id
        params.put("appClientId", config.getAppClientId());
        //设置app client secret
        params.put("appClientSecret", config.getAppClientSecret());
        //调用接口返回token
        String res = HttpHelper.doPostJson(url, params);
        //解析结果
        JSONObject jsonObject = JSONObject.parseObject(res);
        try {
            //返回token
            token = jsonObject.getJSONObject("body").getString("access_token");
            return token;
        } catch (Exception e) {
            logger.error(res, e);
            throw new AccessDenyException("fail to get app token, return message is " + res);
        }
    }

    /**
     * 从缓存中获取token
     *
     * @param config 配置参数
     * @param force  是否强制获取token，为true时强制重新获取token，并存入缓存
     * @return 申请的token
     * @author vimin
     * @since 2021-08-11
     */
    public static String acquireTokenFromCache(Config config, boolean force) throws Exception {
        if (StringUtils.isEmpty(token) || force) {
            return applyAppToken(config);
        } else {
            return token;
        }
    }

    public static String applyUserToken(Config config, String username, String password) throws Exception {
        Client client = new Client(config);
        ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest();
        applyTokenRequest.setUsername(username);
        applyTokenRequest.setPassword(password);
        ResponseOk<TokenInfo> responseOk = client.applyToken(applyTokenRequest);
        if (responseOk.getCode() == 200) {
            return responseOk.getBody().getAccess_token();
        } else {
            throw new AccessDenyException("fail to get user token " + responseOk.getMsg());
        }
    }

    public static String extractAppid(String restApi) {
        while (restApi.endsWith("/")) {
            restApi = restApi.substring(0, restApi.length() - 1);
        }
        return restApi.substring(restApi.length() - 6);
    }
}
