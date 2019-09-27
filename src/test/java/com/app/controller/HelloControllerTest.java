package com.app.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Description
 * @Author acer
 * @Date 2019/9/11 20:09
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {
    @Autowired
    private TestRestTemplate template;
    @Test
    public void test() {
        String forObject = template.getForObject("/add", String.class);
        Assert.assertEquals("add", forObject);
    }

    public static void main(String[] args){
        String str = "abcd.jsp";
        System.out.println(str.matches("([a-zA-Z0-9])?\\.jsp"));
    }
}
