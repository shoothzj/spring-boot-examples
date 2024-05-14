package com.github.shoothzj.reactor.mysql.config.code;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
public class SecondaryDatabaseClientConfiguration {
    @Bean("secondaryDatabaseClient")
    public DatabaseClient secondaryDatabaseClient() {
        ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, "mysql")
                .option(ConnectionFactoryOptions.HOST, "localhost")
                .option(ConnectionFactoryOptions.PORT, 3308)
                .option(ConnectionFactoryOptions.USER, "root")
                .option(ConnectionFactoryOptions.DATABASE, "nopwd_db")
                .build();
        ConnectionFactory connectionFactory = ConnectionFactories.get(options);
        return DatabaseClient.create(connectionFactory);
    }
}
