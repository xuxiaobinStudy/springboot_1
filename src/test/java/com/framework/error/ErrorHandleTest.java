package com.framework.error;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description TODO
 * @Author acer
 * @Date 2019/9/14 20:53
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorHandleTest {
    @MockBean
    private JunitTest junitTest;

    @Test(expected = RuntimeException.class)
    public void test() {
        BDDMockito.given(junitTest.add("a")).willReturn("a");
        BDDMockito.given(junitTest.add("")).willThrow(new RuntimeException());
        Assert.assertEquals("a", junitTest.add("a"));
        Assert.assertEquals("a", junitTest.add(""));
    }
}
