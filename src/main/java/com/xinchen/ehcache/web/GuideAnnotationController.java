package com.xinchen.ehcache.web;

import com.xinchen.ehcache.core.Response;
import com.xinchen.ehcache.core.TestObject;
import com.xinchen.ehcache.service.CacheAnnotationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

/**
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

    @GetMapping("/cache/{key}")
    public Response getKey(@PathVariable("key") int key){
        return Response.ok(Collections.singletonList(cacheService.get(key)));
    }
}
