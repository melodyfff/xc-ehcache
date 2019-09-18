package com.xinchen.ehcache.web;

import com.xinchen.ehcache.core.Response;
import com.xinchen.ehcache.core.TestObject;
import com.xinchen.ehcache.service.CacheAnnotationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

/**
 *
 * {@link org.springframework.cache.annotation.Cacheable} 注解的使用
 *
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2019/9/15 23:27
 */
@RestController
@RequestMapping("/v2")
public class GuideAnnotationController {
    @Resource
    @Qualifier("cacheWithAnnotation")
    private CacheAnnotationService<TestObject> cacheService;

    @GetMapping("/list/{key}")
    public Response getListKey(@PathVariable("key") String key){
        // 模拟返回一个集合
        return Response.ok(Collections.singletonList(cacheService.getAll(key)));
    }


    @GetMapping("/{key}")
    public Response getKey(@PathVariable("key") int key){
        // 模拟获取返回
        return Response.ok(Collections.singletonList(cacheService.get(key)));
    }

    @PutMapping("/{key}")
    public Response put(@PathVariable("key") int key){
        // 模拟更新操作
        return Response.ok(Collections.singletonList(cacheService.put(key)));
    }

    @DeleteMapping("/{key}")
    public Response delete(@PathVariable("key") int key){
        // 模拟删除操作
        cacheService.delete(key);
        return Response.ok(null);
    }
}
