package com.xy.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

/**
 * @program: girl
 * @author: wxy
 * @create: 2018-11-03 12:02
 * @desc:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeServiceTest {
    @Test
    @PostConstruct
    public void someMethod() throws Exception {
        SomeService someService=new SomeService();
        someService.someMethod();
    }

    @PostConstruct
    public void test() {
        SomeService someService=new SomeService();
        someService.someMethod();
    }

}