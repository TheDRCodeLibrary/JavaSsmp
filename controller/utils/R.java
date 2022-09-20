package com.test.controller.utils;
import lombok.Data;
/**
 * @author : DR
 * @version : 1.0
 * @date : 2022/9/18/11:39
 * @Problem description:
 * @Solution:
 */
//全后端格式统一管理模型
//后端统一返回数据R，便于前后端信息统一
@Data   //可以代替Get、Set、toString()方法
public class R {
    //定义属性
    private Boolean flag;//标明操作是否成功
    private Object data;//封装数据
    private String msg;//记录异常信息

    //提供多种构造器，便于返回多种类型信息
    public R(Boolean flag){
        this.flag = flag;
    }
    public R(){}

    public R(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }
    public R(Boolean flag, String msg){
        this.flag = flag;
        this.msg = msg;
    }
    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }
}
