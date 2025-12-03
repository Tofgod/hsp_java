package com.string_;

public class Test03 {
    public static void main(String[] args) {

        String name = "jack";
        int age = 10;
        double sorce = 98.34;
        char denger = '男';

        //占位符 %s  %d %.2f %c
        String f = "姓名%s , 年龄%d ,分数 %.2f , 性别%c";
        String info = String.format(f, name ,age,sorce,denger);
        System.out.println(info);
    }
}
