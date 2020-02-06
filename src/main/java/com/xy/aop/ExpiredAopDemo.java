package com.xy.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-11-03 12:41
 * @desc:
 **/
@EnableAspectJAutoProxy
@SpringBootApplication
public class ExpiredAopDemo {
    @Autowired
    SomeService someService;
    public static void main(String[] args) {
        SpringApplication.run(ExpiredAopDemo.class);
    }
    @PostConstruct
    public void test(){
        someService.someMethod();
    }
}
