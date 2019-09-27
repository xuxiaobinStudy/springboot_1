package com.framework.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 处理全局异常
 * @Author acer
 * @Date 2019/9/14 21:37
 **/
@ControllerAdvice
public class ErrorController {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String allErrorHandler(Exception e) {
        System.out.println("出差了，异常controller");
        return "出错了，全局处理";
    }
}
