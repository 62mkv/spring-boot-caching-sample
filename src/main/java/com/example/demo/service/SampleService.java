package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SampleService {
    private static final Logger log = LoggerFactory.getLogger(SampleService.class);
    private Random random = new Random();

    @Cacheable(cacheNames = "sample")
    public String getGreeting() {
        log.info("Service is called!");
        final String value = String.format("==========%d==========", random.nextInt(100));
        log.info("Value {} is returned from service", value);
        return value;
    }
}
