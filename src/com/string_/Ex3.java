package com.string_;

import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        String name = "Han shun Ping";
        String[] a = name.split(" ");
        System.out.println(a[2] + "," +a[0] + " ."+a[1].toUpperCase().charAt(0));
        String c = String.format("%s,%s .%c" ,a[2] , a[0] ,a[1].toUpperCase().charAt(0) );
        System.out.println(c);

        String str = "23131aA";
        t(str);

        String e = "e";
        String r = "h" + e;
        String v = "he";
        System.out.println(r.intern() == v);

    }
    public static void t( String str ){
        char[] cArr = str.toCharArray();
        for (char c : cArr) {
            if (c >= '0' && c <= '9') {
                System.out.println("数字");
            }
            if (c >= 'a' && c <= 'z') {
                System.out.println("小写字母");
            }
            if (c >= 'A' && c <= 'Z') {
                System.out.println("大写字母");
            }
        }
    }
}
