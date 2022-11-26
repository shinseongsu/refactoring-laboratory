package com.van.server.util;

public class StringUtils {

    public static String appendData(String msg) {
        int length = 80;
        int a = length - msg.getBytes().length;
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        for (int i = 0; i < a; i++) {
            sb.append(" ");
        }
        String result = sb.toString();
        return result;
    }

}
