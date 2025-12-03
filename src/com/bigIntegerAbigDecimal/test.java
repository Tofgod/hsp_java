package com.bigIntegerAbigDecimal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class test {
    public static void main(String[] args) {
        //        new BigInteger()  保存较大的整数
        //        new BigDecimal()。保存精度更高的浮点数
        BigInteger b = new BigInteger("21313213113131131");
        System.out.println(b);
        BigInteger c =  b.add(new BigInteger("1"));
        System.out.println(c);

        BigDecimal bigDecimal = new BigDecimal("213131.3213131123123213213");
        BigDecimal bigDecimal1 = new BigDecimal("0.3213131123123213213");
        System.out.println(bigDecimal);
        BigDecimal add = bigDecimal.add(bigDecimal1);
        System.out.println(add);

//        BigDecimal divide = bigDecimal.divide(bigDecimal1);
//        System.out.println(divide);  //除不尽会抛出算数异常
        BigDecimal divide1 = bigDecimal.divide(bigDecimal1 , BigDecimal.ROUND_CEILING); //指定精度  保留分子的精度
        System.out.println(divide1);

    }
}
