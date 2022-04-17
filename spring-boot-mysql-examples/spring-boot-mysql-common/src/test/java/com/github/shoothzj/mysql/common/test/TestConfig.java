package com.github.shoothzj.mysql.common.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories({"com.github.shoothzj.mysql.common.repository"})
@SpringBootApplication(scanBasePackages = "com.github.shoothzj.mysql")
@EntityScan(basePackages = {"com.github.shoothzj.mysql.common.domain"})
public class TestConfig {
}
