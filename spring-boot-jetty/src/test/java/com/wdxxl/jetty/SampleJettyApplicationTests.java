package com.wdxxl.jetty;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

import com.wdxxl.jetty.SampleJettyApplication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleJettyApplication.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SampleJettyApplicationTests {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void testHome() {
        ResponseEntity<String> entity =
                new TestRestTemplate().getForEntity("http://localhost:" + port, String.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
        Assert.assertEquals("Hello World", entity.getBody());
    }

    @Test
    public void testCompression() throws IOException {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept-Encoding", "gzip");
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        RestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<byte[]> entity = restTemplate.exchange(
                "http://localhost:" + port, HttpMethod.GET, requestEntity, byte[].class);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
        GZIPInputStream inflater = new GZIPInputStream(new ByteArrayInputStream(entity.getBody()));
        try{
            Assert.assertEquals("Hello World", StreamUtils.copyToString(inflater, Charset.forName("UTF-8")));
        } finally {
            inflater.close();
        }
    }
}
