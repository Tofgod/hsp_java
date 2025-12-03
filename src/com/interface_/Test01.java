package com.interface_;

public class Test01 {
    public static void main(String[] args) {
        Inter01.h1();
    }
}

//方法默认是 public 而且是 abstract。子类必须实现
//抽象类实现接口 可以不用实现方法
interface Inter01{
    public int n1 = 10;

    public void hi();

    // jdk8后 可以用default修饰 写默认方法
    default public void h2(){

    }

    // jdk8后 可以用static修饰
    public static void h1(){

    }
}


// 如果一个类 implements  需要改接口的所有抽象方法都实现
class A implements Inter01{

    @Override
    public void hi() {

    }
}
