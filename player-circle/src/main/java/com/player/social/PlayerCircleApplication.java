package com.player.social;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.player.social")
@MapperScan("com.player.social.mapper")
public class PlayerCircleApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlayerCircleApplication.class, args);
    }

    @Bean
    @LoadBalanced//在注册中心里进行查找微服务,负载均衡
    public RestTemplate restTemplate(){

        RestTemplate restTemplate=new RestTemplate();
        return  restTemplate;
    }
}