package com.backbonerestapp.api.controller;

import com.backbonerestapp.api.dao.CustomerDao;
import com.backbonerestapp.api.model.User;
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
    private CustomerDao customerDao;

    @Autowired
    private EhCacheManagerFactoryBean cacheManager;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    @ResponseBody
    public String findUser(String imsi) {
        LOGGER.info("Processing request for /customer...");

        User user = customerDao.findUser(imsi);

        CacheManager myCacheManager = cacheManager.getObject();
        Cache customerCache = myCacheManager.getCache("customerCache");
        LOGGER.info("Cache Size: " + customerCache.getSize());
        for(Object key : customerCache.getKeys()) {
            LOGGER.info("Key: "+key+" Value: "+customerCache.get(key));
        }

        return user != null ? user.getUserLabel() : "Not Found";
    }
}
