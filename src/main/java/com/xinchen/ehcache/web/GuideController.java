package com.xinchen.ehcache.web;

import com.xinchen.ehcache.core.Response;
import com.xinchen.ehcache.core.TestObject;
import com.xinchen.ehcache.service.CacheService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;


/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/19 21:21
 */
@RestController
@RequestMapping("/v1")
public class GuideController {

    @Resource
    @Qualifier("cacheWithProgram")
    private CacheService<TestObject> cacheService;

    @GetMapping("/")
    public Response keys(){
        // 返回所有的keys
        return Response.ok(cacheService.getKeys());
    }


    @GetMapping("/cache/{key}")
    public Response getKey(@PathVariable("key") String key){
        return Response.ok(Collections.singletonList(cacheService.get(key)));
    }

    @GetMapping("/list")
    public Response list(){
        return Response.ok(cacheService.getAll());
    }

    @PutMapping("/put/{times}")
    public Response put(@PathVariable("times") int times){
        if (times<=0){
            return Response.ok(null);
        }
        for(int i = 0;i<times;i++){
            cacheService.put(String.valueOf(i),new TestObject(i,new Date()));
        }
        return Response.ok(null);
    }
}
