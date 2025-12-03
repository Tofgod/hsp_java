package com.static__;

import java.util.Arrays;

public class ChildGame {

    //代码块 应用场景 抽取构造器的公共部分  提高代码的复用性
    {}

    //main方法是虚拟机调用 所以一定是public
    //虚拟机调用main方法的时候 不用创建对象 所以需要static
    //String[] args 接受java命令参数
    public static void main(String[] args) {

        //
        System.out.println(Arrays.toString(args));


        Child c1 = new Child("2132");
        Child c2 = new Child("2132");
        Child c3 = new Child("2132");

        System.out.println(Child.count);
        System.out.println(c1.count);




        //类加载的时候成成一个class对象 在堆  类变量 是在class对象上面的
        //类变量在 类加载的时候就生成的； 类变量在加载时候就初始
        // 化了 即使没有创建对象 可以直接通过 类名.类变量名访问

        //类变量的生命周期 是随着类加载开始 类消亡而销毁


        //类方法无法访问this 因为加载的时候 还没有this
        // 类方法 只能访问 static 字段

    }
}

class Child{
    private String name;
    //类变量 静态变量  被所有对象实例共享
    public static int count;

    public Child(String name) {
        this.name = name;
        count ++ ;
    }

    public static void a(){
    }


}
