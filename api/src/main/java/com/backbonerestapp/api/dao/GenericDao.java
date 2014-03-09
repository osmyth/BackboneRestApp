package com.backbonerestapp.api.dao;

import com.googlecode.ehcache.annotations.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class GenericDao {

    @Cacheable(cacheName = "customerCache")
    public String getCustomer(int id) {
        System.out.println("============= getting from DB ===============");
        return "John Doe";
    }

}
