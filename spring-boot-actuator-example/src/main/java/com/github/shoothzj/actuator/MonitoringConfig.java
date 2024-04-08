package com.github.shoothzj.actuator;

import io.micrometer.core.instrument.Clock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonitoringConfig {

    @Bean
    public LogMeterRegistry loggingMeterRegistry(@Autowired LogRegistryConfig logRegistryConfig) {
        return new LogMeterRegistry(logRegistryConfig, Clock.SYSTEM);
    }
}
