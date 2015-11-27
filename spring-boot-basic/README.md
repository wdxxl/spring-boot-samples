### 1. 例子项目简单说明 ###
它由[** Gradle **](http://gradle.org/) 管理依赖jar文件, 项目的最简单启动例子 

相关细节：  
+ **01 Download repo** ./gradlew cleanEclipse eclipse 完成项目的编译和依赖文件下载  
+ **02 Run As Application** Run  SpringBootExample 启动Spring Boot 项目, 内嵌tomcat可以允许直接访问 [Localhost](http://localhost:8080/)
+ **03 Execution Jar** gradle build & java -jar build/libs/mySpringBootBasic-0.0.1-SNAPSHOT.jar
 
参考网站： 
+ [** Spring Boot Docs **](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#gettting-started-first-application)
