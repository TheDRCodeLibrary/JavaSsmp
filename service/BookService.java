package com.test.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.test.domain.Book;

import java.util.List;

/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/17/10:50
 * @Problem description:
 * @Solution:
 */
//定义业务层接口
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage, int pageSize);
}
