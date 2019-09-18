package com.xinchen.ehcache.service;

import com.xinchen.ehcache.core.TestObject;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 使用注解的方式,官网：
 *
 * https://docs.spring.io/spring/docs/5.2.0.BUILD-SNAPSHOT/spring-framework-reference/integration.html#cache-annotations
 *
 *
 * 注： key的类型要保持一致，如 int key 和String key 即使值相同，也会缓存不同的对象
 *
 *
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2019/9/15 23:22
 */
@Service("cacheWithAnnotation")
@CacheConfig(cacheNames = "hello")
public class CacheAnnotationServiceImpl implements CacheAnnotationService<TestObject> {

    @Cacheable(key = "#key")
    @Override
    public TestObject get(int key) {
        return new TestObject(key,new Date());
    }

    @CachePut(key = "#key")
    @Override
    public TestObject put(int key) {
        return new TestObject(key, new Date());
    }

    @CacheEvict(key = "#key",condition = "#key >= 2")
    @Override
    public void delete(int key) {
        // do delete...
    }


    @Caching(cacheable = {@Cacheable(key = "#key+'-hello'")})
    @Override
    public List<TestObject> getAll(String key) {
        // 模拟返回很多
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.singletonList(new TestObject(Integer.parseInt(key), new Date()));
    }


}
