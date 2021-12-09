package com.github.shoothzj.springcloud.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudZooKeeperExample {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZooKeeperExample.class, args);
    }

}
