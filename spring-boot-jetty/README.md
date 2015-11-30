### 1. 简单说明 ###
+ 基于**内嵌Jetty**, 用其gzip的内容压缩方式访问

相关细节:   
+ **01 Download repo** ./gradlew cleanEclipse eclipse 完成项目的编译和依赖文件下载  
+ **02 Run As Application** Run  SampleJettyApplication 启动Spring Boot 项目
+ **03 Execution Jar** gradle build & java -jar build/libs/mySpringBootJetty-0.0.1-SNAPSHOT.jar 
+ **04 Unit Test** use unit test to check Accept-Encoding:gzip 
+ **05 Restful**
``
    Status Code: 200 OK
    **Content-Encoding: gzip**
    Content-Type: text/html; charset=UTF-8
    Date: Mon, 30 Nov 2015 09:27:38 GMT
    **Server: Jetty(9.2.14.v20151106)**
    Transfer-Encoding: chunked
    Vary: Accept-Encoding, User-Agent
``

参考网站: 
+ [** Embedded Jetty **](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-jetty)
+ [** Jetty Compression **](http://blog.max.berger.name/2010/01/jetty-7-gzip-filter.html)

扩展学习: 
+ Accept-Encoding: gzip
+ Content-Encoding: gzip

常见报错信息: 
+ (java.util.zip.ZipException: Not in GZIP format) 默认: server.compression.enabled:false, 开启后所有访问都是gzip形式
