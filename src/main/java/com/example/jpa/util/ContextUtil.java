package com.example.jpa.util;


import org.springframework.context.ApplicationContext;

public class ContextUtil {

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getContext(){
        return applicationContext;
    }
}
