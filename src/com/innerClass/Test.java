package com.innerClass;

public class Test {
    public static void main(String[] args) {

    }
}

//难点 重点 源码有很多内部类
//类的那五大成员 属性 方法 构造器 代码块 内部类
//内部类  一个类又完整的嵌套了另一个类结构
//内部类 可以访问私有属性
//内部类 四种
//定义在外部类局部位置上 （比如方法内）
// 1 局部内部类（有类名） 2 匿名内部类（没有类名）！！！
//定义在外部类的成员位置上
// 1 成员内部类（没有用static修饰） 2静态内部类（static修饰）

class Outer{

    private int n1 = 100;

    {
        System.out.println("代码块");
    }

    public Outer() {
        System.out.println("构造器");
    }

    public void mi(){
        n1 = 20;
        System.out.println(n1);
    }

    //内部类
    class Inner{

    }
}