package com.github.shoothzj.actuator;

import io.micrometer.core.instrument.step.StepRegistryConfig;
import org.springframework.stereotype.Service;

@Service
public class LogRegistryConfig implements StepRegistryConfig {
    @Override
    public String prefix() {
        return "management.influx.metrics.export";
    }

    @Override
    public String get(String key) {
        if ("log.step".equals(key)) {
            return "1m";
        }
        return null;
    }
}