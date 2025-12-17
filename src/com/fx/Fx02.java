package com.fx;

public class Fx02 {
    public static void main(String[] args) {

        Person<String> s = new Person<>("s");

    }
}

class Person <T>{  //该数据类型 在创建的时候被定义 在编译期间就确定了
    String s;
    T c; // 这个属性的数据类型 在创建的时候被定义

    public Person(T s) {
        this.c = s;
    }

    public T ss(){
        return c;
    }

}
