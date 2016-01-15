package com.wdxxl.rest.client;

import java.util.HashMap;
import java.util.Map;

import com.wdxxl.common.model.HelloWorld;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class BasicExample {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8080/", String.class);
        System.out.println(result);
    }

    @Test
    public void testHelloWorld() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("age", "28");
        vars.put("name", "king.wang");
        HelloWorld result = restTemplate.getForObject(
                "http://localhost:8080/wdxxl?age={age}&name={name}", HelloWorld.class, vars);
        System.out.println(result.getAge() + ":" + result.getName());
    }

}
