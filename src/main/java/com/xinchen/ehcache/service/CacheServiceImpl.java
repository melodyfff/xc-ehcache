package com.xinchen.ehcache.service;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/19 22:40
 */
@Service
public class CacheServiceImpl implements CacheService {

    private static String DEFAULT_CACHE = "xinchen";

    private Cache defaultCache;


    @Resource
    private CacheManager cacheCacheManager;



    @Override
    public List getAll() {
        checkStatus();

        final List keys = defaultCache.getKeys();
        List returnList = new ArrayList();
        keys.forEach(x->{
            returnList.add(defaultCache.get(x).getObjectValue());
        });
        return returnList;
    }

    @Override
    public void put(String key,Object o) {
        checkStatus();
        defaultCache.put(new Element(key,o));
    }


    protected void checkStatus(){
        if (null==defaultCache){
            defaultCache = cacheCacheManager.getCache(DEFAULT_CACHE);
        }
    }


}
