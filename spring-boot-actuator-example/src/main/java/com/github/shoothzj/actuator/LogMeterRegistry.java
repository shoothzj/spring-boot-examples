package com.github.shoothzj.actuator;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.step.StepMeterRegistry;
import io.micrometer.core.instrument.step.StepRegistryConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class LogMeterRegistry extends StepMeterRegistry {

    public LogMeterRegistry(StepRegistryConfig config, Clock clock) {
        super(config, clock);
    }

    @Override
    protected void publish() {
        log.info("Publishing metrics...");
        getMeters().forEach(meter -> {
            log.info("Meter: {}, Value: {}", meter.getId(), meter.measure());
        });
    }

    @Override
    protected TimeUnit getBaseTimeUnit() {
        return TimeUnit.SECONDS;
    }

}
