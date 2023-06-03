package com.lit.util;

public class CheckUtil {
    public static void isEmpty(String str) throws Exception {
        if (str == null) {
            throw new Exception("空参数");
        }
        if (str.trim() == null) {
            throw new Exception("空参数");
        }
    }
}
