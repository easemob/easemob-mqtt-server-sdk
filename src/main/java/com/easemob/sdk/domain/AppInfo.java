package com.easemob.sdk.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppInfo {
    private String domain;
    private String appid;
    private String port;
}
