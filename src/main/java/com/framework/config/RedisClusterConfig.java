package com.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

/**
 * @Description redis集群配置类
 * @Author acer
 * @Date 2019/9/20 13:06
 **/
@Profile("test")
@Configuration
public class RedisClusterConfig {

    @Value("${spring.redis.cluster.nodes}")
    private String nodes;

    @Bean("jedisCluster")
    public JedisCluster createJedisCluster() {
        // 切割集群节点
        String[] split = nodes.split(",");
        // 将所有结点分割为ip和端口组装成HostAndPort对象
        HashSet<HostAndPort> hostAndPorts = new HashSet<>();
        for (String single : split) {
            String[] split1 = single.split(":");
            HostAndPort hostAndPort = new HostAndPort(split1[0], Integer.valueOf(split1[1]));
            // 将所有对象放入set集合中
            hostAndPorts.add(hostAndPort);
            System.out.println("===================="+hostAndPort.toString());
        }
        // 根据传入的set集合创建redis集群对象，还可以调用其它构造方法传入更详细的配置信息
        JedisCluster jedisCluster = new JedisCluster(hostAndPorts);
        return jedisCluster;
    }

}
