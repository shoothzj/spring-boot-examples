package com.github.shoothzj.mysql.config.yaml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author hezhangjian
 */
@Slf4j
@EnableJpaAuditing
@EnableJpaRepositories({"com.github.shoothzj.mysql.common.repository"})
@SpringBootApplication(scanBasePackages = "com.github.shoothzj.mysql")
@EntityScan(basePackages = {"com.github.shoothzj.mysql.common.domain"})
public class MysqlConfigYamlExample {

    public static void main(String[] args) {
        SpringApplication.run(MysqlConfigYamlExample.class);
    }

}
