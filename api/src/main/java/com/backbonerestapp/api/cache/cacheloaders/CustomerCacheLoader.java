package com.backbonerestapp.api.cache.cacheloaders;

import com.backbonerestapp.api.cache.SimpleCacheKeyGenerator;
import com.googlecode.ehcache.annotations.key.CacheKeyGenerator;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.Status;
import net.sf.ehcache.loader.CacheLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;

public class CustomerCacheLoader implements CacheLoader {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerCacheLoader.class);

    private Ehcache cache;

    public CustomerCacheLoader(Ehcache cache) {
        this.cache = cache;
    }

    public Object load(Object key) throws CacheException {
        return null;
    }

    public Map loadAll(Collection keys) {
        return null;
    }

    public Object load(Object key, Object argument) {
        return null;
    }

    public Map loadAll(Collection keys, Object argument) {
        return null;
    }

    public String getName() {
        return cache.getName();
    }

    public CacheLoader clone(Ehcache cache) throws CloneNotSupportedException {
        return new CustomerCacheLoader(cache);
    }

    public void init() {
        CacheKeyGenerator cacheKeyGenerator = new SimpleCacheKeyGenerator();

        LOGGER.info("Initialising " + cache.getName() + "...");
        for(int i = 0; i < 10; i ++ ) {
            cache.put(new Element(cacheKeyGenerator.generateKey(i), "John Doe "+i), true);
        }
        LOGGER.info("Cache Initialised! " + cache.getSize());
    }

    public void dispose() throws net.sf.ehcache.CacheException {}

    public Status getStatus() {
        return cache.getStatus();
    }
}
