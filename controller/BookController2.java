package com.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.test.domain.Book;
import com.test.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/18/9:27
 * @Problem description:
 * @Solution:
 */

//@RestController//标注Rest风格开发，Controller层
@RequestMapping("/books")
public class BookController2 {
    //注入业务层信息
    @Autowired
    private IBookService bookService;

    @GetMapping//限定提交方式
    public List<Book> getAll(){//查询所有数据
        return bookService.list();
    }
    @PostMapping
    public Boolean save( @RequestBody Book book){//增加数据
        return bookService.save(book);
    }
    @PutMapping
    public Boolean update(@RequestBody Book book){//修改数据
        return bookService.updateById(book);
    }
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){//删除数据
        return bookService.removeById(id);
    }
    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){//查询单个数据
        return bookService.getById(id);
    }
    @GetMapping("/{currentPage}/{pageSize}")//分页查询
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return bookService.getPage(currentPage, pageSize);
    }
}
