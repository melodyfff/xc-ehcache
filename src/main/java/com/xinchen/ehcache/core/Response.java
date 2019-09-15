package com.xinchen.ehcache.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/19 22:13
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    /** 默认成功 **/
    private Status status;

    private String message;

    private List<T> data;


    public Response(Status status, String message, List<T> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static Response<?> ok(List<?> data){
        return new Response<>(Status.OK, "success.", data);
    }

    public static Response<?> fail(){
        return new Response<>(Status.BADREQUEST, "fail.", null);
    }

    public static Response<?> fail(String message){
        return new Response<>(Status.BADREQUEST, message, null);
    }

    public static Response<?> of(Status status,String message, List<?> data){
        return new Response<>(status, message, data);
    }
}
