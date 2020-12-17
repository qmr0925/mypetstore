package org.csu.mypetstore.util;

import java.util.Random;

public class RandomNumberUtil {
    public static String getRandomNumber() {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            buffer.append(random.nextInt(10) + "");
        }
        return buffer.toString();
    }
}
