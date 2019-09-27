package com.framework.init;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author acer
 * @Date 2019/9/14 10:37
 **/
@Component
public class ApplicationContextEventTest implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("加载spring上下文前执行");
    }
}
