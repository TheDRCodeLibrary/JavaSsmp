package com.test.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.test.domain.Book;
import org.springframework.context.annotation.ImportSelector;

/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/17/19:44
 * @Problem description:
 * @Solution:
 */
//自己定义接口无非就是CRUED,可以实现接口自动完成，并且可以根据实际需要自己新增特需的，使用公共的
public interface IBookService extends IService<Book> {

    //定义分页查询
    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);

//    boolean save(Book book);//定义自己方法
}
