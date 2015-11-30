package com.wdxxl.simple.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SampleSimpleApplication {

    @Component
    static class Runner implements CommandLineRunner {
        @Autowired
        private HelloWorldService helloWorldService;

        @Override
        public void run(String... args) throws Exception {
            System.out.println(helloWorldService.getHelloMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SampleSimpleApplication.class);
        application.setApplicationContextClass(AnnotationConfigApplicationContext.class);
        application.run(args);
    }
}
