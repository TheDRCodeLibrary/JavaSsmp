package com.test.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/17/9:47
 * @Problem description:
 * @Solution:
 */
//声明配置类
@Configuration
public class MPConfig {
    //配置MyBatis-Puls拦截器
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();//创建拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());//向拦截器中添加分页相关类
        return interceptor;//返回配置好的拦截器
    }

}
