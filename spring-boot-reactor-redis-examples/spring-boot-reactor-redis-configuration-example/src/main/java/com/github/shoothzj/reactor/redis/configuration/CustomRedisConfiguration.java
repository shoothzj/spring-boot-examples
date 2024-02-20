package com.github.shoothzj.reactor.redis.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class CustomRedisConfiguration {

    @Profile("!test")
    @Bean
    public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory(
            @Value("${REDIS_HOST}") String host,
            @Value("${REDIS_PORT}") int port,
            @Value("${REDIS_PASSWORD}") String password) {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(host);
        config.setPort(port);
        config.setPassword(password);
        return new LettuceConnectionFactory(config);
    }

    // 测试环境下的配置
    @Profile("test")
    @Bean
    public ReactiveRedisConnectionFactory testReactiveRedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
        return new LettuceConnectionFactory(config);
    }
}
