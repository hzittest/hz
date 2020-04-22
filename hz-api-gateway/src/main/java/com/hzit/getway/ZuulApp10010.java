package com.hzit.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
//@EnableEurekaClient    //服务注册 只支持eureka
@EnableDiscoveryClient //服务注册 支持多种服务注册中心 ，包括eureka
@EnableZuulProxy
public class ZuulApp10010 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApp10010.class, args);
    }
}
