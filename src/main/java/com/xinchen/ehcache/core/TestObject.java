package com.xinchen.ehcache.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/18 22:45
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class TestObject implements Serializable {
    private String name;
}
