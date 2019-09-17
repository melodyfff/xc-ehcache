package com.xinchen.ehcache.service;

import com.xinchen.ehcache.core.TestObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 使用注解的方式
 *
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2019/9/15 23:22
 */
@Service("cacheWithAnnotation")
public class CacheAnnotationServiceImpl implements CacheAnnotationService<TestObject> {

    @Cacheable(value = "hello",key = "#key")
    @Override
    public TestObject get(int key) {
        return new TestObject(key,new Date());
    }

    @Override
    public List<TestObject> getAll() {
        return null;
    }

    @Override
    public void put(String key, TestObject o) {

    }
}
