package com.easemob.sdk.api;

import com.easemob.sdk.Config;
import com.easemob.sdk.utils.TokenUtils;

/**
 * 抽象请求类，提供获取app token默认实现
 *
 * @author vimin
 * @since 2021-08-11
 */
public abstract class AbstractRequest implements IRequest {
    /**
     * 获取app token
     *
     * @param config 配置类
     * @param force  是否强制刷新token，true为强制，false为非强制
     * @return
     * @throws Exception
     */
    @Override
    public String acquireAppToken(Config config, boolean force) throws Exception {
        return TokenUtils.acquireTokenFromCache(config, force);
    }

}
