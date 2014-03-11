package com.backbonerestapp.api.dao;

import com.backbonerestapp.api.model.Customer;
import com.googlecode.ehcache.annotations.Cacheable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class GenericDao {

    private final Logger LOGGER = LoggerFactory.getLogger(GenericDao.class);

    @Autowired
    private DataSource dataSource;

    @Cacheable(cacheName = "customerCache", keyGeneratorName="cacheKeyGenerator")
    public Customer findCustomer(int customerId) {
        LOGGER.info("Getting data from DB: " + customerId);

        Customer customer = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery("select * from customers where customer_id =" + customerId);

            while(resultset.next()) {
                String customerName = resultset.getString("customer_name");
                customer = new Customer(customerId, customerName);
            }

        } catch (Exception e) {
            LOGGER.error("Error accessing the database", e);
        } finally {
            JdbcUtils.closeConnection(connection);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeResultSet(resultset);
        }

        return customer;
    }

}
