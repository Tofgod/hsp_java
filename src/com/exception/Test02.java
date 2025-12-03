package com.exception;

public class Test02 {
    public static void main(String[] args) {


        //空指针异常
        try {
            String name = null;
            System.out.println(name.length());
        } catch (Exception e) {
//            throw new RuntimeException(e);

            //NullPointerException
        }
        System.out.println("@13");

        //索引超限
        try {
            int [] a = {10};
            System.out.println(a[11]);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            //ArrayIndexOutOfBoundsException
        }

        System.out.println("@13");

        //类型转换异常
        try {
            A b = new B();
            B b2 = (B)b;
            C c2 = (C)b;
        } catch (Exception e) {
            //ClassCastException
//            throw new RuntimeException(e);
        }

        //数字格式不正确异常 NumberFormatException
        try {
            String name = "你好你好";
            int num = Integer.parseInt(name);
        } catch (NumberFormatException e) {
//            throw new RuntimeException(e);
        }
    }
}

class A{}
class B extends  A{ }
class C extends  A{ }

