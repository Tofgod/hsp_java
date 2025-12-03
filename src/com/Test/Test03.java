package com.Test;

public class Test03 {
    public static void main(String[] args) {
        A a = new A();
        a.f();
    }
}

class A {

    private String name = "@31" ;

    public void f(){

        class B {
            private final String name = "wqeq";
            public void show(){
                System.out.println(name);
                System.out.println(A.this.name);
            }

        }

        B b = new B();
        b.show();
    }
}
