package com.backbonerestapp.api.cache;

import net.sf.ehcache.*;
import net.sf.ehcache.loader.CacheLoader;
import net.sf.ehcache.loader.CacheLoaderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class CustomerCacheLoaderFactory extends CacheLoaderFactory {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerCacheLoaderFactory.class);

    public CacheLoader createCacheLoader(Ehcache cache, Properties properties) {
        LOGGER.info("Creating Customer Cache Loader: " + cache.getStatus());
        return new CustomerCacheLoader(cache);
    }
}
