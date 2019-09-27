package com.framework.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author acer
 * @Date 2019/9/14 11:37
 **/
@Component
public class EventTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=-------");
    }
}
