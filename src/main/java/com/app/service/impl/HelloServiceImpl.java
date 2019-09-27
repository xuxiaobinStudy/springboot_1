package com.app.service.impl;

import com.app.mapper.HelloMapper;
import com.app.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author acer
 * @Date 2019/9/21 12:20
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;

    @Override
    public void getNumber() {
        System.out.println("users表的数据量：" + helloMapper.getNumber());
    }
}
