package com.backbonerestapp.api.dao;

import com.backbonerestapp.api.model.User;
import com.googlecode.ehcache.annotations.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CustomerDao extends Repository<User, Long> {
//
//    @Cacheable(cacheName = "customerCache", keyGeneratorName = "cacheKeyGenerator")
//    @Query(value="select c from Customer c where customer_id = ?1")
//    public Customer findCustomer(int id);
//
//    @Query(value="select c from Customer c")
//    public List<Customer> findAllCustomers();

    @Cacheable(cacheName = "customerCache", keyGeneratorName = "cacheKeyGenerator")
    @Query(value="select u from User u where imsi_id = ?1")
    public User findUser(String imsi);

    @Query(value="select u from User u")
    public List<User> findAllUsers();
}
