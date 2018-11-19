package com.xinchen.ehcache.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/19 22:27
 */
public interface CacheService {
    List getAll();

    void put(String key,Object o);
}
