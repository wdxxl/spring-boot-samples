package com.wdxxl.tomcat.controller;

import com.wdxxl.tomcat.service.HelloWorldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/")
    @ResponseBody
    public String helloWorld() {
        return helloWorldService.getHelloMessage();
    }
}
