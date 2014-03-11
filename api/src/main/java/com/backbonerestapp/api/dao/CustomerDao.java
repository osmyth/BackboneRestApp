package com.backbonerestapp.api.dao;

import com.backbonerestapp.api.model.Customer;
import com.googlecode.ehcache.annotations.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface CustomerDao extends Repository<Customer, Long> {

    @Cacheable(cacheName = "customerCache", keyGeneratorName = "cacheKeyGenerator")
    @Query(value="select c from Customer c where customer_id = ?1",nativeQuery = true)
    public Customer findCustomer(int id);
}
