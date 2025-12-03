package com.innerClass;

public class Test01 {
    public static void main(String[] args) {

    }
}

//局部内部类

class Outer01 {
    private int n1 ;

    public void m1(){

        // 局部内部类 //可以访问外部类的所有成员 包括private
        // 不能添加访问修饰符 可以使用final 不能被继承
        final class Inner{
            public void f1(){
                System.out.println(n1);
                m2();
            }
        }

//        class Aa extends Inner{}
    }

    private void m2(){

    }
}
