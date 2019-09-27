package com.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description 将JedisPool对象交给springboot容器
 * @Author acer
 * @Date 2019/9/20 8:57
 **/
@Profile("test")
@Configuration
@ConfigurationProperties
public class RedisPoolConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.timeout}")
    private Integer timeout;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private Long maxWaitMillis;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.block-when-exhausted}")
    private Boolean blockWhenExhausted;
    private Logger log = LoggerFactory.getLogger(RedisPoolConfig.class);

    @Bean("jedisPool")
    public JedisPool createJedisPool() {
        log.info("配置jedispool开始");
        // 先创建jedispool的配置类
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认true
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, Integer.valueOf(port), timeout, password);
        log.info("配置jedispool完成：" + jedisPool);
        return jedisPool;
    }
}
