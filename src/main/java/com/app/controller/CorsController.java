package com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 使用CORS注解实现跨域
 * @Author acer
 * @Date 2019/9/23 20:23
 **/
@Controller
public class CorsController {

    private Logger log = LoggerFactory.getLogger(CorsController.class);

    @CrossOrigin("127.0.0.1:8081")
    @RequestMapping("/cors/test")
    public void testCors(){
        System.out.println("CORS跨域Controller");
    }





}
