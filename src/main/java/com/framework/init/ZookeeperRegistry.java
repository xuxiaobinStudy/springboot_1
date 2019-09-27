package com.framework.init;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Description spring启动完成后，将服务注册到zookeeper注册中心
 * @Author acer
 * @Date 2019/9/15 21:08
 **/
@Profile("test")
@Component
public class ZookeeperRegistry implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 连接zookeeper，并设置重试策略
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.0.166:2181",
                new ExponentialBackoffRetry(1000, 3));
        client.start();
        client.blockUntilConnected();

        // 将服务注册到zookeeper上
        ServiceInstance<Object> builder = ServiceInstance.builder().name("springboot1").address("192.168.0.106").port(8080).build();
        ServiceDiscovery<Object> discovery = ServiceDiscoveryBuilder.builder(Object.class)
                .client(client).basePath("/single").build();
        discovery.registerService(builder);
        discovery.start();
    }
}
