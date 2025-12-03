package com.final_;

public class Test {

    public static void main(String[] args) {
        //final static 搭配使用 效率更高 不会除法类的加载
        System.out.println(AA.a); //触发类的加载
        System.out.println(AA.c); //不触发类的加载


        //什么是包装类
        //包装类，String 是final 不能被继承
    }
}


// 命名规范 XXX_XXX_XXX 大写
//不希望继承 可用final
//final static 搭配使用 效率更高 不会除法类的加载 底层做了优化
// 除非初始化是在静态代码块
class AA{
    public final static int a;
    public final static int c = 1;
    public static int b = 2;
    static {
        a = 1;
        System.out.println("1111");
    }

}


final class A {}


//class B extends A{}


class C {
    public final int a ;

    public final static  int b ;

    static {
        b = 1;
    }

    {
        a = 1;
    }

    public C(){
//        a = 1;
//        b = 1;
    }


    public final void hi(){

    }
}
class D extends C{
//    public void hi(){}
}