package com.github.shoothzj.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class MyComponent {
    private final Counter myCounter;

    public MyComponent(MeterRegistry meterRegistry) {
        myCounter = meterRegistry.counter("my.custom.counter");
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(this::myMethod, 1, 1, TimeUnit.SECONDS);
    }

    public void myMethod() {
        myCounter.increment();
    }
}
