package com.xinchen.ehcache.service;


import java.util.List;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/19 22:27
 */
public interface CacheAnnotationService<T> {

    /**
     * 根据key获取对象
     * @param key String
     * @return T
     */
    T get(int key);

    /**
     * 插入缓存
     * @param key key
     * @return T
     */
    T put(int key);

    /**
     * 删除
     * @param key key
     * @return T
     */
    void delete(int key);
}
