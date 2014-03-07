package com.backbonerestapp.api.dao;

import com.googlecode.ehcache.annotations.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class GenericDao {

    @Cacheable(cacheName = "messageCache")
    public String getCustomer(int id) {
        return "John Doe";
    }

}
