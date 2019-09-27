package com.app.common.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description TODO
 * @Author acer
 * @Date 2019/9/11 22:54
 **/
@Configuration
@PropertySource("classpath:config/datasource.properties")
public class DataSourceConf {
}
