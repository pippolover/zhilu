package com.springapp.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Created by yimingwym on 15/12/6.
 */
public class RandomUtil {

    public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }

    public static String generateStringFromUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}
