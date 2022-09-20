package com.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/15/21:09
 * @Problem description:
 * @Solution:
 */
//使用mybatis-Pul
@Mapper//标明mybatis-Pul创建的实体，代替相关xml配置
public interface BookDao extends BaseMapper<Book> {
    //自带各种常用操作函数（CRUD）
}

////普通不使用mybatis-Pul
//@Mapper
//public interface BookDao {
//    @Select("select * from tbl_book where id = #{id}")
//    Book getById(Integer id);
//}
