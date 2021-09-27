package com.easemob.sdk.api;

import com.easemob.sdk.Config;
import com.easemob.sdk.domain.ResponseOk;

/**
 * 全部API基类
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-11
 */
public interface IRequest {
    /**
     * 执行API具体的逻辑
     *
     * @param config 配置类信息
     * @return
     * @throws Exception
     */
    ResponseOk execute(Config config) throws Exception;

    /**
     * 获取app类型的token
     *
     * @param config 配置类信息
     * @param force  是否强制刷新token
     * @return
     * @throws Exception
     */
    String acquireAppToken(Config config, boolean force) throws Exception;
}
