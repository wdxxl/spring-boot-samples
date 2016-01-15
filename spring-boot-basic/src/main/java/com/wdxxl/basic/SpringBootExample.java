package com.wdxxl.basic;

import javax.servlet.http.HttpServletRequest;

import com.wdxxl.common.model.HelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class SpringBootExample {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/wdxxl")
    public @ResponseBody HelloWorld buildHelloWorld(ModelMap model, HttpServletRequest request,
            @RequestParam(value = "age") int age, @RequestParam(value = "name") String name) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setAge(age);
        helloWorld.setName(name);
        return helloWorld;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExample.class, args);
    }
}
