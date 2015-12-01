package com.wdxxl.activemq;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleActiveMQApplication.class)
public class SampleActiveMqTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();
    // OutputCapture is a JUnit Rule that you can use to capture System.out and System.err output.

    @Autowired
    private Producer producer;

    @Test
    public void sendSimpleMessage() throws InterruptedException {
        producer.send("test message");
        Thread.sleep(1000L);
        Assert.assertTrue(outputCapture.toString().contains("test message"));
    }
}
