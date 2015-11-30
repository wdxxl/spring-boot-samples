package com.wdxxl.tomcat;

import com.wdxxl.tomcat.NonAutoConfigurationSampleTomcatApplicationTests.NonAutoConfigurationSampleTomcatApplication;
import com.wdxxl.tomcat.controller.SampleController;
import com.wdxxl.tomcat.service.HelloWorldService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(NonAutoConfigurationSampleTomcatApplication.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class NonAutoConfigurationSampleTomcatApplicationTests {

    @Value("${local.server.port}")
    private int port;

    @Configuration
    @Import({EmbeddedServletContainerAutoConfiguration.class,
            DispatcherServletAutoConfiguration.class,
            ServerPropertiesAutoConfiguration.class,
            WebMvcAutoConfiguration.class,
            HttpMessageConvertersAutoConfiguration.class,
            PropertyPlaceholderAutoConfiguration.class})
    @ComponentScan(basePackageClasses = {SampleController.class, HelloWorldService.class})
    public static class NonAutoConfigurationSampleTomcatApplication {
        public static void main(String[] args) {
            SpringApplication.run(SampleTomcatApplication.class, args);
        }
    }

    @Test
    public void testHome(){
        ResponseEntity<String> entity =
                new TestRestTemplate().getForEntity("http://localhost:" + port, String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
        Assert.assertEquals("Hello World", entity.getBody());
    }
}
