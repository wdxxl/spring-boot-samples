package com.wdxxl.simple.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

    @Value("${name:World}")
    private String name; // 如果没有配置文件配置该Key值， 则默认用当前的内容

    public String getHelloMessage() {
        return "Hello " + name;
    }
}
