package com.backbonerestapp.api.controller;

import com.backbonerestapp.api.dao.GenericDao;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*/
@Controller
@RequestMapping("/")
public class APIController {

    private final Logger LOGGER = LoggerFactory.getLogger(APIController.class);

    @Autowired
    private GenericDao genericDao;

    @Autowired
    private EhCacheManagerFactoryBean cacheManager;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    @ResponseBody
    public String getCustomer(int id) {
        LOGGER.info("Processing request for /customer...");
        String customer = genericDao.getCustomer(id);
        if(customer == null) {
            customer = "Not Found";
        }

        CacheManager myCacheManager = cacheManager.getObject();
        Cache customerCache = myCacheManager.getCache("customerCache");
        LOGGER.info("Cache Size: " + customerCache.getSize());
        for(Object key : customerCache.getKeys()) {
            LOGGER.info("Key: "+key+" Value: "+customerCache.get(key));
        }

        return customer;
    }
}
