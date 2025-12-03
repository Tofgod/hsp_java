package com.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;

public class Test02 {
    public static void main(String[] args) {

    }
}

//元注解
// 元注解用于修饰其他注解

// @Retention()
//表示注解保留多长时间 作用时间
// SOURCE  表示 编译器使用后 直接丢弃这中策略的注解
// CLASS  表示编译器把注解记录在class文件中 运行java程序时候 jvm不保留注解
// RUNTIME 表示表示编译器把注解记录在class文件中 运行java程序时候 jvm会保留注解  可以通过反射获取注解

//@Target 用于修饰 注解可以修饰的元素  类型 方法 参数 构造器 局部变量 软件包


// @Document 用于指定被该元注解修饰的注解类 将被javadoc工具提取成文档 在生成文档时可以看到 该注解
// @Document时 @Retention() 必须是 RUNTIME3

// @Inherited 继承
// 被他修饰的注解 具有继承性  被修饰的类在被继承的时候 自动带上该注解