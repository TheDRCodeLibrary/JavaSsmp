package com.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.dao.BookDao;
import com.test.domain.Book;
import com.test.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/17/19:48
 * @Problem description:
 * @Solution:
 */
//接口中包含常规操作的实现，如果接口中额外定义方法则需要单独实现
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired//注入数据层接口方法
    private BookDao bookDao;

    //实现service接口中自己定义的其他方法
    @Override//传入当前页和每页数据量
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page(currentPage, pageSize);
        //dao接口继承了mybatis-Pul中提供的方法BaseMapper，其中包含一系列方法操作，其中包含分页查询操作
        bookDao.selectPage(page, null);//
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        //组织条件
        //若type类型不为nill,则模糊查询符合type值信息
        //参数（查询不为空--调用实体类Book中的具体方法--like的条件即通过book.方法查出来的数据）
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        IPage page = new Page<>(currentPage, pageSize);
        bookDao.selectPage(page, lqw);
        return page;
    }

//    @Override
//    public boolean save(Book book) {//添加自己定义方法
//        return false;
//    }
}
