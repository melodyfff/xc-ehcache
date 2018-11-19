package com.xinchen.ehcache.core;

/**
 * 返回状态码
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/19 22:15
 */
public enum Status {
    /****/
    OK(200, "OK"),
    /****/
    CREATED(201,"Created"),
    /****/
    BADREQUEST(400,"Bad Request");


    /** 状态码 **/
    private int status;
    /** 消息 **/
    private String code;

    /**
     * 构造
     * @param status 状态码
     * @param code code
     */
    Status(int status, String code) {
        this.status = status;
        this.code = code;
    }
}
