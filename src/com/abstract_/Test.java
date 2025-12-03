package com.abstract_;

public class Test {
    public static void main(String[] args) {

    }
}


//当一个类中存在抽象方法时 需要讲该类声明为abstract类  不可以被实例化
abstract class Animal {
    private String name;

    public static int a = 1;

    public Animal(String name) {
        this.name = name;
    }

    //抽象方法 没有实现的方法 无方法体
//    public void eat(){
//
//    }


    public abstract void eat();

}

class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }



    public  void eat(){
        System.out.println("吃西瓜");
    };

}