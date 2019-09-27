package com.app.controller;

import com.app.service.impl.HelloServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Description 初始测试入口
 * @Author acer
 * @Date 2019/9/11 20:09
 **/
@Controller
public class HelloController {

    private Logger log = LoggerFactory.getLogger(HelloController.class);
    @Value("${server.port}")
    private String port;
    @Resource
    private Environment env;
    /*@Autowired
    private JedisCluster jedisCluster;*/
    @Autowired
    private HelloServiceImpl helloServiceImpl;

    @RequestMapping("/test")
    public String test() {
        helloServiceImpl.getNumber();
        /*System.out.println("名称是：" + jedisCluster.get("name"));*/
        int i = 0;
        System.out.println("正常controller类");
        if (i == 0) {
            throw new RuntimeException("异常了");
        }
        return "index";
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add() {
        return "add";
    }


}
