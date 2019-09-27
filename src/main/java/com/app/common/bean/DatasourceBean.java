package com.app.common.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description 测试：将配置文件中的信息装入bean中
 * @Author acer
 * @Date 2019/9/11 22:59
 **/
@Component
@ConfigurationProperties(prefix = "server")
public class DatasourceBean {
    public void setPort(String port) {
        this.port = port;
    }
    private String port;

    public void show() {
        System.out.println(this.port);
    }
}
