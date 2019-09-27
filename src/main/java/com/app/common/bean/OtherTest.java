package com.app.common.bean;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;

import java.util.Collection;

/**
 * @Description 客户端向zookeeper获取服务节点信息
 * @Author acer
 * @Date 2019/9/18 19:58
 **/
public class OtherTest {
    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.0.166:2181", new ExponentialBackoffRetry(1000, 3));
        client.start();
        client.blockUntilConnected();

        ServiceDiscovery serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class)
                .client(client)
                .basePath("/single")
                .build();
        serviceDiscovery.start();

        //根据名称获取服务
        Collection<ServiceInstance> services = serviceDiscovery.queryForInstances("springboot1");
        for (ServiceInstance service : services) {
            System.out.println(service.getPayload());
            System.out.println(service.getAddress() + "\t" + service.getPort());
            System.out.println("---------------------");
        }

        serviceDiscovery.close();
        client.close();
    }
}
