package com.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author acer
 * @Date 2019/9/14 21:14
 **/
@Controller
public class ErrorPages {
    @RequestMapping("/error/404")
    public String page404() {
        return "404";
    }

    @RequestMapping("/error/error")
    public String pageError() {
        System.out.println("错误页面controller");
        return "error";
    }
}
