package com.backbonerestapp.api.dao;

import com.googlecode.ehcache.annotations.Cacheable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GenericDao {

    private final Logger LOGGER = LoggerFactory.getLogger(GenericDao.class);

    @Cacheable(cacheName = "customerCache", keyGeneratorName="cacheKeyGenerator")
    public String getCustomer(int id){
        String customerName = "John Doe " + id;
        LOGGER.info("Getting data from DB: " + id + " - " + customerName);

        if(id > 20) {
            return null;
        }

        return customerName;
    }

}
