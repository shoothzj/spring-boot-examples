package com.github.shoothzj.reactor.mysql.config.code;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
public class PrimaryDatabaseClientConfiguration {
    @Primary
    @Bean("primaryDatabaseClient")
    public DatabaseClient primaryDatabaseClient(R2dbcProperties r2dbcProperties) {
        ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, "mysql")
                .option(ConnectionFactoryOptions.HOST, "localhost")
                .option(ConnectionFactoryOptions.PORT, 3306)
                .option(ConnectionFactoryOptions.USER, "root")
                .option(ConnectionFactoryOptions.DATABASE, "nopwd_db")
                .build();
        ConnectionFactory connectionFactory = ConnectionFactories.get(options);
        return DatabaseClient.create(connectionFactory);
    }

    @Primary
    @Bean(name = "primaryR2dbcProperties")
    public R2dbcProperties r2dbcProperties() {
        String url = String.format("r2dbc:mysql://%s:%d/%s", "localhost", 3306, "nopwd_db");
        R2dbcProperties properties = new R2dbcProperties();
        properties.setUrl(url);
        properties.setUsername("root");
        return properties;
    }
}
