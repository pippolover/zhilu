package com.springapp.utils;

import java.util.Calendar;

/**
 * Created by yimingwym on 15/10/6.
 */
public class DateHelper {
    /**
     * 获取当年年份的后两位数
     * @return
     */
    public static String getCurrentYear(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return String.valueOf(year).substring(2);
    }

    public static void main(String[] args){
        System.out.println(getCurrentYear());
    }
}
