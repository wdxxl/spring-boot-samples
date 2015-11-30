### 1. 例子项目简单说明 ###
它由[** Gradle **](http://gradle.org/) 管理依赖jar文件, 项目的最简单启动例子.

相关细节:   
+ **01 Download repo** ./gradlew cleanEclipse eclipse 完成项目的编译和依赖文件下载  
+ **02 Run As Application** Run  SampleSimpleApplication 启动Spring Boot 项目, Command Line & Run As --> Run Configurations --> Arguments (--name=test)
+ **03 Execution Jar** gradle build & java -jar build/libs/mySpringBootSimple-0.0.1-SNAPSHOT.jar --name=test
 
参考网站: 
+ [** Spring Boot Sample Simple **](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-simple)

常见报错信息: 
+ (e.g. if you put a @ComponentScan in the default package by mistake)