package com.easemob.sdk.utils;

/**
 * 字符串操作类
 *
 * @author vimin
 * @since 2021-08-11
 */
public class StringUtils {
    /**
     * 判断一个字符串是否为空
     *
     * @param str 目标字符串
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断一个字符串是否非空
     *
     * @param str 目标字符串
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }

    /**
     * 判断一个字符串是否为null
     *
     * @param s
     * @return
     */
    public static boolean isNull(String s) {
        return s == null;
    }

    /**
     * 判断一个字符串是否为空串
     *
     * @param s
     * @return
     */
    public static boolean isBlank(String s) {
        return s != null && s.trim().length() == 0;
    }

    /**
     * 判断一个字符串是否不为空串
     *
     * @param s
     * @return
     */
    public static boolean isNotBlank(String s) {
        return s != null && s.trim().length() > 0;
    }
}
