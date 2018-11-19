package com.xinchen.ehcache.web;

import com.xinchen.ehcache.core.Response;
import com.xinchen.ehcache.core.TestObject;
import com.xinchen.ehcache.service.CacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/19 21:21
 */
@RestController
@RequestMapping("/v1")
public class GuideController {

    @Resource
    private CacheService cacheService;

    @GetMapping("/hello")
    public Response hello(){
        return new Response();
    }

    @GetMapping("/list")
    public Response list(){
        Response response = new Response();
        response.setData(cacheService.getAll());
        return response;
    }

    @PutMapping("/put/{times}")
    public Response put(@PathVariable("times") int times){
        if (times<=0){
            return new Response();
        }
        for(int i = 0;i<times;i++){
            cacheService.put(String.valueOf(i),new TestObject(String.valueOf(System.currentTimeMillis())));
        }
        return new Response();
    }



}
