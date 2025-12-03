package com.interface_;

public class Test02 {
    public static void main(String[] args) {
        System.out.println(IA.a);
    }
}

// 实现接口 继承类的区别
//

interface IA{
    //接口的属性 只能是 public static final
    public static final int a = 1;
    int b = 2; //隐藏了public static final
    void h1();
}
interface IB{
    void h2();
}

//接口不能继承类 但是可以继承接口

interface ID extends IA,IB{}

// 一个类可以实现多个接口
class Cc implements IA ,IB {
    @Override
    public void h1() {

    }

    @Override
    public void h2() {

    }
}
