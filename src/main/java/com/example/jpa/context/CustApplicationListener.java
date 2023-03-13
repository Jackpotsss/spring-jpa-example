package com.example.jpa.context;

import com.example.jpa.util.ContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

@Component
public class CustApplicationListener implements ApplicationListener<ApplicationContextEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        ContextUtil.setApplicationContext(applicationContext);
    }
}
