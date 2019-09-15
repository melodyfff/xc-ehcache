package com.xinchen.ehcache.service;


import java.util.List;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/19 22:27
 */
public interface CacheService<T> {

    /**
     * 根据key获取对象
     * @param key String
     * @return T
     */
    T get(String key);

    /**
     * 获取全部
     * @return List
     */
    List<T> getAll();

    /**
     * 插入缓存
     * @param key key
     * @param o T
     */
    void put(String key,T o);

}
