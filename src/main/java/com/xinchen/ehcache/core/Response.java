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
    private Status status = Status.OK;

    private String message = "success.";

    private List<T> data;
}
