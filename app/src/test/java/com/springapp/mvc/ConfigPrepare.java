package com.springapp.mvc;

import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by yimingwym on 15/4/22.
 */
public class ConfigPrepare {
    public static void initProperties(String filename) throws Exception{
        Properties pros = new Properties();
        pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
        Enumeration enumeration = pros.propertyNames();
        while (enumeration.hasMoreElements()){
            String elements = (String)enumeration.nextElement();
            System.setProperty(elements,pros.getProperty(elements));
        }

    }
}
