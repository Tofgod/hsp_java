package com.Test;

public class Test04 {
    public static void main(String[] args) {


        Person p = new Person("唐僧" ,null);

        p.passL();
        p.passR();



    }
}

interface Vehicles{
    void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("使用马");
    }
}

class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("使用船");
    }
}

class Tools{

    private static Horse h = new Horse();
    private static Boat b = new Boat();

    private Tools(){}

    public static Horse getHorse(){
        return h ;
    }

    public static Boat getBoat(){
        return b;
    }
}

class Person{
    private String name ;
    private Vehicles Vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.Vehicles = vehicles;
    }

    public void passR(){
        if (!(Vehicles instanceof Boat) ){
            Vehicles = Tools.getBoat();
        }
        Vehicles.work();
    }

    public void passL(){
        if (!(Vehicles instanceof Horse) ){
            Vehicles = Tools.getHorse();
        }
        Vehicles.work();
    }

}
