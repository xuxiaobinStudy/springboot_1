package com.framework.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author acer
 * @Date 2019/9/14 20:53
 **/
@Component
public class ErrorHandle implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        ErrorPage errorPage1 = new ErrorPage(RuntimeException.class, "/error/error");
        registry.addErrorPages(errorPage, errorPage1);
    }
}
