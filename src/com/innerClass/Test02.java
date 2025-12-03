package com.innerClass;


public class Test02 {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}

class Outer02 {

    public void m1(){
        //1.实现接口  匿名内部类  只使用一次  简化开发
        // 匿名内部类 用于对接口的方法的直接实现
        // 运行类型 编译类型
        //特点 tiger 的编译类型是什么 是接口A  运行类型是什么 匿名内部类
        /* 系统分配的类名 实现
        * class Outer02$1 implements Aa {
        *
              @Override
            public void cry() {
                System.out.println("tigger cry");
            }
        * }
        *
        * */
        //在底层在创建了匿名内部类后 立马马上就创建了一个实例 并且把地址返回给tiger
        //用完一次 就没了
        A tiger = new A(){
            @Override
            public void cry() {
                System.out.println("tigger cry");
            }
        };
        tiger.cry();
        System.out.println(tiger.getClass());  // Outer02$1  外部类的名字加了 $1

        //编译类型 FA 运行类型是匿名内部类
        //底层创建匿名累不累
        // class  Outer02$2 extends FA。继承
        FA fa = new FA("jack"){

            @Override
            //重写了cry方法
            public void cry() {
                System.out.println("重写了父类的方法");
            }
        };  //加一个大括号 就是匿名内部类 大括号里面写方法
        System.out.println(fa.getClass());
    }
}

interface A{
    public void cry();
    public default void cry1(){}
}

class FA implements A{

    private String name;

    public FA(String name) {
        this.name = name;
    }

    @Override
    public void cry() {

    }
}

//匿名内部类 必须实现抽象方法
abstract class An{
    abstract void a();
}
