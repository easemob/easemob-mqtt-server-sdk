package com.easemob.sdk.domain;

public enum OrderParams {
    ASC("ASC"),
    DESC("DESC"),
    asc("ASC"),
    desc("DESC");

    private final String value;

    private OrderParams(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public boolean equalsName(String otherValue) {
        return value.equals(otherValue);
    }

    public String toString() {
        return this.value;
    }
}
