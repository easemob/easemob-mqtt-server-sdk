package com.easemob.sdk.domain;

import lombok.*;

@Builder(access = AccessLevel.PUBLIC)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOk<C> {
    private int code;
    private String msg;
    private C body;

    public static ResponseOk.ResponseOkBuilder responseOkBuilder() {
        return new ResponseOk.ResponseOkBuilder();
    }
}
