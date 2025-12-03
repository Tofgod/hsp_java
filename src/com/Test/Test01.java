package com.Test;

public class Test01 {
    public static void main(String[] args) {

        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        Frock frock = new Frock();
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();

        System.out.println(frock.serialNumber);
        System.out.println(frock1.serialNumber);
        System.out.println(frock2.serialNumber);

    }
}

class Frock{
    private static int currentNum = 100000;

    public int serialNumber ;

    public static int getNextNum(){
        return currentNum+=100;
    }

    public Frock() {
        this.serialNumber = getNextNum();
    }
}

abstract class Animal{
    abstract void shout();
}

class Cat extends Animal{
    @Override
    void shout() {
        System.out.println("cat cry");
    }
}

