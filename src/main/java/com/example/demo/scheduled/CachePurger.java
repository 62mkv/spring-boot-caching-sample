package com.example.demo.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CachePurger {
    private static final Logger log = LoggerFactory.getLogger(CachePurger.class);
    private final CacheManager cacheManager;

    public CachePurger(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Scheduled(fixedDelay = 5000L)
    public void purgeCache() {
        String cacheName = "sample";
        cacheManager.getCache(cacheName).clear();
        log.info("Cache {} is purged", cacheName);
    }

}
