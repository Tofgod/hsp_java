package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;

public class Test01 {

    //抑制警告 不希望看到警告
    //可以写入 你希望抑制的警告信息

//    @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
//    @Retention(RetentionPolicy.SOURCE)
//    public @interface SuppressWarnings {
//        String[] value(); 可以传一个数组进来
//    }
    @SuppressWarnings({"all","unchecked","unused"})
    public static void main(String[] args) {
        A a = new A();
        a.a();

        List list = new ArrayList();
        list.add("");
        list.add("");
        list.add("");
        int i ;
        System.out.println(list.get(1));



    }
}

//注解
//修饰某个元素 表示已经过时了 但是还能用 只是不推荐使用
//修饰 方法 类 字段 包 参数 等等
@Deprecated
class B {
    void a () {

    }
}

@Deprecated
class A extends B{

    //注解 放在方法前 表示该方法是重写了父类的方法
    // 如果没写 Override 还是重写的关系
    // Override 的价值 如果写了 Override
    // 编译器就会检查该方法是否真的重写了父类的摸个方法 如果没有构成重写则编译错误
    // 语法校验
    // 看看 Override 的定义 是一个注解类 可以有属性 方法
    //@Target(ElementType.METHOD)
    //@Retention(RetentionPolicy.SOURCE)
    //public @interface Override {
    //}

    // @Target  元注解 修饰注解的注解

    @Override
    @Deprecated
    void a() {
        super.a();
    }


    void b(){

    }
}

