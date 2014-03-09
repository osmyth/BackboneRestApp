package com.backbonerestapp.api.cacheloaders;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.loader.CacheLoader;
import net.sf.ehcache.loader.CacheLoaderFactory;

import java.util.Properties;

public class CustomerCacheLoaderFactory extends CacheLoaderFactory {

    public CacheLoader createCacheLoader(Ehcache cache, Properties properties) {
        System.out.println("============== createCacheLoader ===============");
        return new CustomerCacheLoader(cache);
    }
}
