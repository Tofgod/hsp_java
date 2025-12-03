package com.string_;

public class Test {
    public static void main(String[] args) {


        String a = "abc";
        //方式一 先去常量池里面找 有就给地址 没有就创建


        String s = new String(new char[]{'a','b','c'});
        //方式一 创建给vlaue【】 复制 寻找常量 有就赋值 没有就创建 然后赋值给value
        System.out.println(s);

        s.intern(); //返回常量池中的字符串的地址
        System.out.println(s.intern());
        System.out.println(a == s.intern()); //abc常量池的地址 是一样的 所以相等
        System.out.println(s == s.intern());

        String aq = "b" + "v";
        //编译器会优化 会先运算  生成“bv” 常量
        //常量相加在池子

        String aq1 = "tt";  //创建 t
        String aq2 = "yyy";  //创建 y
        String aq3 = aq1 + aq2 ; // 指向的是一个String对象  value ->指向池中的“ttyyy”
        //1. 先创建 StringBuilder a = StringBuilder() 对象
        //2. 执行a.append("tt")方法
        //3. 执行a.append("yyy")方法
        //4. 执行a.toString() return new String(value , 0 , count)
        //5. 最终是 aq3 指向了一个 String对象  value ->指向池中的“ttyyy”
        // ****  变量相加在堆中

        //看源码学习

    }
}

//string 使用 unicode 字母汉字占两个字节
