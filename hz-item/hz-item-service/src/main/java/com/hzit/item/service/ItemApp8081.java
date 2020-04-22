package com.hzit.item.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hzit.item.service.mapper")
public class ItemApp8081 {

    public static void main(String[] args) {
        SpringApplication.run(ItemApp8081.class, args);
    }
}
