package com.warpper_;

public class Test03 {
    public static void main(String[] args) {

        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b); //false

        Integer c = 1;
        Integer d  = 1;
        Integer.valueOf(1); //
        // 如果是这个范围  -128 to 127, 直接返回 如果不是这个范围 就 new Integer(1)
        System.out.println(c == d); //自动装箱了 true

        Integer e = 128;
        Integer g = 128;
        System.out.println(e == g ); //false

         // 当  Integer 跟 int 比较 就是比较值是否相等

    }
}
