package com.xinchen.ehcache.service;

import com.xinchen.ehcache.core.TestObject;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 未使用注解的方式
 *
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/19 22:40
 */
@Service("cacheWithProgram")
public class CacheServiceImpl implements CacheService<TestObject>, InitializingBean {

    private static final String DEFAULT_CACHE = "hello";

    private Cache defaultCache;

    @Resource
    private CacheManager cacheCacheManager;


    @Override
    public TestObject get(String key) {
        return (TestObject) defaultCache.get(key).getObjectValue();
    }

    @Override
    public List<TestObject> getAll() {
        final List<?> keys = defaultCache.getKeys();

        List<TestObject> returnList = new ArrayList<>();

        keys.forEach(x-> returnList.add((TestObject) defaultCache.get(x).getObjectValue()));
        return returnList;
    }

    @Override
    public void put(String key,TestObject o) {
        defaultCache.put(new Element(key,o));
    }


    private void checkStatus(){
        if (null==defaultCache){
            defaultCache = cacheCacheManager.getCache(DEFAULT_CACHE);
        }
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        // 检查是否切换到对应的cache
        checkStatus();
    }
}
