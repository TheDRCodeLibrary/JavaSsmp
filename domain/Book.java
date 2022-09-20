package com.test.domain;

import lombok.Data;

/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/15/21:01
 * @Problem description:
 * @Solution:
 */

@Data//提高代码的简洁性，省去实体类中大量的get()、 set()、 toString()等方法。
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
