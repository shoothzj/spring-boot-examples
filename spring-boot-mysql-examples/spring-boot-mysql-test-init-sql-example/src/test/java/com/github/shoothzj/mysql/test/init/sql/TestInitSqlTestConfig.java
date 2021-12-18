package com.github.shoothzj.mysql.test.init.sql;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories({"com.github.shoothzj.mysql.test.init.sql.repository"})
@SpringBootApplication(scanBasePackages = "com.github.shoothzj.mysql")
@EntityScan(basePackages = {"com.github.shoothzj.mysql.test.init.sql.domain"})
public class TestInitSqlTestConfig {


}
