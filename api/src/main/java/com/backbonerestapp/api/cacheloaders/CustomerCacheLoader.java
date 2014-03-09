package com.backbonerestapp.api.cacheloaders;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.Status;
import net.sf.ehcache.loader.CacheLoader;

import java.util.Collection;
import java.util.Map;

public class CustomerCacheLoader implements CacheLoader {

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
        System.out.println("Init Cache ===============================");
        cache.put(new Element(0, "John Doe 0"), true);
        cache.put(new Element(1, "John Doe 1"), true);
        cache.put(new Element(2, "John Doe 2"), true);
        cache.put(new Element(3, "John Doe 3"), true);
        cache.put(new Element(4, "John Doe 4"), true);
        cache.put(new Element(5, "John Doe 5"), true);
        cache.put(new Element(6, "John Doe 6"), true);
        cache.put(new Element(7, "John Doe 7"), true);
    }

    public void dispose() throws net.sf.ehcache.CacheException {}

    public Status getStatus() {
        return cache.getStatus();
    }
}
