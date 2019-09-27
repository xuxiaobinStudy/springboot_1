package com;

import com.app.common.bean.DatasourceBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description 启动类
 * @Author acer
 * @Date 2019/9/11 20:03
 **/
@SpringBootApplication
public class ApplicationStart {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationStart.class, args);
        DatasourceBean datasourceBean = (DatasourceBean) run.getBean("datasourceBean");
        datasourceBean.show();
    }
}
