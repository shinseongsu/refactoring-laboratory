package com.van.server.util;

import static com.van.server.util.StringUtils.appendData;

public class DataUtils {

    public static String buildData() {
        String msgCode = "";
        String msgCode_01 = "TCP0001";
        msgCode = msgCode_01;
        String msgContent = "Response OK";
        msgContent = appendData(msgContent);
        String cnt = "4    ";
        String data1 = "11111111            은행계좌01      bank01              active              ";
        String data2 = "22222222            은행계좌02      bank02              active              ";
        String data3 = "33333333            은행계좌03      bank03              active              ";
        String data4 = "44444444            은행계좌04      bank04              active              ";
        String dataAll = msgCode + msgContent + cnt + data1 + data2 + data3 + data4;

        return dataAll;
    }

}
