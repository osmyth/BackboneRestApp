package com.backbonerestapp.api.cache;

import com.googlecode.ehcache.annotations.key.CacheKeyGenerator;
import org.aopalliance.intercept.MethodInvocation;

import java.io.Serializable;

public class SimpleCacheKeyGenerator implements CacheKeyGenerator<Serializable> {

    @Override
    public Serializable generateKey(final MethodInvocation arg0) {
        return generateKey(arg0.getArguments());
    }

    @Override
    public Serializable generateKey(final Object... arg0) {
        int key = 0;
        if(arg0.length == 1){
            key = (Integer) arg0[0];
        }
        return key;
    }
}