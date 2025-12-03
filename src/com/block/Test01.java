package com.block;

public class Test01 {
    public static void main(String[] args) {
        new BBB();
    }
}

class AAA {

    static {
        System.out.println("AAA static代码块");
    }


    {
        System.out.println("AAA 普通代码块");
    }


    public AAA() {
        System.out.println("AAA 构造器被调用");
    }
}


class BBB extends AAA {


    static {
        System.out.println("BBB static代码块");
    }

    {
        System.out.println("BBB 普通代码块");
    }


    public BBB() {
        System.out.println("BBB 构造器被调用");
    }
}