package com.math_;


public class Test01 {
    //math 数学运算的一些方法

    public static void main(String[] args) {

        int abs = Math.abs(-1);
        System.out.println(abs);

        double pow = Math.pow(2,4); //2的4次方
        System.out.println(pow);

        double c = Math.ceil(-9.9);
        System.out.println(c); //向上取整

        double f = Math.floor(-9.9);
        System.out.println(f); //向下取整

        double r = Math.round(0.5);
        System.out.println(r);

        double k = Math.sqrt(9.0); //开平方
        System.out.println(k);



        for (int i = 0; i < 20; i++) {
            int d = (int) (Math.random() * (7 - 2 + 1) + 2); // + 1 是因为要取7 不取7不用加1
            System.out.println(d);
        }


        int rr = Math.max(10 , 2);
        int r1 = Math.min(10 , 2);
        System.out.println(rr );
        System.out.println(r1);



    }



}
