package com.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.test.controller.utils.R;
import com.test.domain.Book;
import com.test.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/18/9:27
 * @Problem description:
 * @Solution:
 */

@RestController//标注Restfull风格开发，Controller层
@RequestMapping("/books")
public class BookController {
    //注入业务层信息
    @Autowired
    private IBookService bookService;

    @GetMapping//限定提交方式
    public R getAll(){//查询所有数据
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {//增加数据
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);
//        r.setDate(null);
//        return r;//等价替换

        if(book.getName().equals("null")) throw new IOException();//异常测试
        Boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!" );
    }

    @PutMapping
    public R update(@RequestBody Book book){//修改数据
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){//删除数据
        return new R(bookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){//查询单个数据
        return new R(true, bookService.getById(id));
    }
//    @GetMapping("/{currentPage}/{pageSize}")//分页查询
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        if(currentPage >  page.getPages()){
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new R(true, page);
//    }
    //按条件查询

    @GetMapping("/{currentPage}/{pageSize}")//分页查询
    //将信息传入后端（当前页-每页数据量-Book相关参数可以一起接收）---使用SpringMVC传参机制，也可以调整接收参数形式
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        //异常判断
        if(currentPage >  page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }
}
