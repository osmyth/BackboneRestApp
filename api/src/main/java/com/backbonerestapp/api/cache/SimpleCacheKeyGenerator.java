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

        for (int i = 0; i < arg0.length; i++) {
            key += arg0[i].hashCode();
        }

        return key;
    }
}