package com.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test01 {

    public static void main(String[] args)  {



        //异常处理机制
        try {
            int a = 0;
            int b = 10;
            int c = b/a;
        } catch (Exception e) {
//            throw new RuntimeException(e);
//            System.out.println();
            e.printStackTrace();
            System.out.println("异常的原因" + e.getMessage());
        }

        System.out.println("wqeq");

        //异常两大类
        // Error  java虚拟机无法解决的文件 如 jvm系统内部错误 资源耗尽 栈溢出  是严重错误 系统会奔溃
        //Exception 编程错误或者偶然的外在因素导致的一般性问题 针对代码进行处理  例如空指针访问  网络连接中断  分为两大类 1.运行时异常 和 2.编译时异常

        //类 Throwable




    }

}

