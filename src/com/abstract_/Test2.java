package com.abstract_;

public class Test2 {
    public static void main(String[] args) {

    }
}

//设计模式：模版模式
class AA{
    public void sum(){

        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间" + (end - start));

    }
}
