package com.block;

public class Test {

    public static void main(String[] args) {
//        new Person("@13");
//        new Person("@13");
        System.out.println(St.a);
//        Person.a = 1;

        //1静态代码块跟静态变量是按照定义顺序执行
        //2.普通变量 之后执行 按照定义顺序执行
        //3最后是构造器执行
    }
}


class Person {


    //类什么时候被加载
    //1.使用类的静态成员时
    //2.创建对象实例的时候。new
    //3.创建子类 父类也会被加载

    //静态代码块 在类加载的时候执行 只会执行一次
    //普通代码块 在类创建的时候执行

    private String name;
    public static int a ;

    //代码块 应用场景 抽取构造器的公共部分  提高代码的复用性
    //构造函数也是在对象创建时被调用，但实例初始化块先于构造函数执行。

    //静态初始化块 类被加载到JVM时执行，且只执行一次。 用于初始化静态变量或执行只需进行一次的初始化操作。
    //实例初始化块 在创建对象时执行，每次创建对象都会执行，且在构造函数之前执行 用于初始化实例变量或执行对象创建时通用的初始化操作
    static {
        System.out.println("Person");
    }




    public Person(String name) {
        this.name = name;
    }
}


class St extends Person{

    public static int a ;
    public static int b ;

    static {
        System.out.println("St");
    }


    public St(String name) {
        super(name);
    }
}

