package com.test.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/19/11:39
 * @Problem description:
 * @Solution:
 */
//springMVC异常处理器
@RestControllerAdvice
public class ProjrctExceptionAdvice {
    //拦截所有异常（底层异常也会抛至表现层）
    @ExceptionHandler
    public R doException(Exception ex){
        //记录日志、通知运维、通知开发
        ex.printStackTrace();//抛出异常信息
        return new R("服务器故障，请联系管理员！");

    }
}
