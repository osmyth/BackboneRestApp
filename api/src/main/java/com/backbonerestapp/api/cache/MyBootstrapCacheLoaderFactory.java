package com.backbonerestapp.api.cache;

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
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MyBootstrapCacheLoaderFactory extends BootstrapCacheLoaderFactory implements BootstrapCacheLoader {

    private final Logger LOGGER = LoggerFactory.getLogger(MyBootstrapCacheLoaderFactory.class);

    @Autowired
    private CacheKeyGenerator cacheKeyGenerator;

    @Autowired
    private DataSource dataSource;

    public MyBootstrapCacheLoaderFactory createBootstrapCacheLoader(Properties properties) {
        return new MyBootstrapCacheLoaderFactory();
    }

    public void load(Ehcache ehCache) throws CacheException {
        Cache cache = ehCache.getCacheManager().getCache("customerCache");

        LOGGER.info("Initialising " + cache.getName() + "...");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery("select * from customers");

            while(resultset.next()) {
                int customerId = resultset.getInt("customer_id");
                String customerName = resultset.getString("customer_name");
                cache.put(new Element(cacheKeyGenerator.generateKey(customerId), customerName), true);
            }

        } catch (Exception e) {
            LOGGER.error("Error accessing the database", e);
        } finally {
            JdbcUtils.closeConnection(connection);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeResultSet(resultset);
        }
        LOGGER.info("Cache Initialised! "+cache.getSize());
    }

    public boolean isAsynchronous() {
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        return null;
    }
}
