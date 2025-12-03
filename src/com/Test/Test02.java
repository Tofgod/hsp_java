package com.Test;

public class Test02 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();

        cellphone.testWork(new Computer() {
            @Override
            public void work() {
                System.out.println("shoujizaigongz");
            }
        });

        cellphone.testWork1(new Computer1(){
            @Override
            void work() {
                System.out.println("dwqnduiq");
            }
        });
    }
}

interface Computer{
    void work();
}

class Computer1{
    void work(){
        System.out.println("wejiqoe");
    };
}

class Cellphone{
    public void testWork(Computer computer){
        computer.work();
    }

    public void testWork1(Computer1 computer){
        computer.work();
    }

}
