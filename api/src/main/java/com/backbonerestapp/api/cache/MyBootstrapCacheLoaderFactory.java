package com.backbonerestapp.api.cache;

import com.googlecode.ehcache.annotations.key.CacheKeyGenerator;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import net.sf.ehcache.bootstrap.BootstrapCacheLoaderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

public class MyBootstrapCacheLoaderFactory extends BootstrapCacheLoaderFactory implements BootstrapCacheLoader {

    private final Logger LOGGER = LoggerFactory.getLogger(MyBootstrapCacheLoaderFactory.class);

    @Autowired
    private CacheKeyGenerator cacheKeyGenerator;

    public MyBootstrapCacheLoaderFactory createBootstrapCacheLoader(Properties properties) {
        return new MyBootstrapCacheLoaderFactory();
    }

    public void load(Ehcache ehCache) throws CacheException {
        Cache cache = ehCache.getCacheManager().getCache("customerCache");

        LOGGER.info("Initialising " + cache.getName() + "...");
        for(int i = 0; i < 10; i ++ ) {
            cache.put(new Element(cacheKeyGenerator.generateKey(i), "John Doe "+i), true);
        }
        LOGGER.info("Cache Initialised! "+cache.getSize());
    }

    public boolean isAsynchronous() {
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        return null;
    }
}