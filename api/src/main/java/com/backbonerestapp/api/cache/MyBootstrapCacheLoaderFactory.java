package com.backbonerestapp.api.cache;

import com.backbonerestapp.api.dao.CustomerDao;
import com.backbonerestapp.api.model.User;
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

import java.util.List;
import java.util.Properties;

public class MyBootstrapCacheLoaderFactory extends BootstrapCacheLoaderFactory implements BootstrapCacheLoader {

    private final Logger LOGGER = LoggerFactory.getLogger(MyBootstrapCacheLoaderFactory.class);

    @Autowired
    private CacheKeyGenerator cacheKeyGenerator;

    @Autowired
    private CustomerDao customerDao;

    public MyBootstrapCacheLoaderFactory createBootstrapCacheLoader(Properties properties) {
        return new MyBootstrapCacheLoaderFactory();
    }

    public void load(Ehcache ehCache) throws CacheException {
        Cache cache = ehCache.getCacheManager().getCache("customerCache");

        LOGGER.info("Initialising " + cache.getName() + "...");
        List<User> users = customerDao.findAllUsers();
        for (User user : users) {
            cache.put(new Element(cacheKeyGenerator.generateKey(user.getImsi()), user), true);
        }
        LOGGER.info("Cache Initialised! " + cache.getSize());
    }

    public boolean isAsynchronous() {
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        return null;
    }
}
