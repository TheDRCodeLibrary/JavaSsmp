package com.test.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.dao.BookDao;
import com.test.domain.Book;
import com.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/17/10:52
 * @Problem description:
 * @Solution:
 */
//定义Service层对应的Bean
@Service
public class BookServiceImplTest implements BookService {
    //注入数据
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;//数据层返回int表示一个操作影响了多少行，在服务层时只关注逻辑，操作是否成功。
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>();
        bookDao.selectPage(page, null);
        return page;
    }
}
