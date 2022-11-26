package com.van.server.util;

public class CalculatorUtils {

    public static int sumUpArray(int[] arrayId, int i) {
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            sum += arrayId[j];
        }
        return sum;
    }

}
