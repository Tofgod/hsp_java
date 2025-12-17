package com.fx;

import java.util.ArrayList;

public class Fx01 {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("21",21));
        arrayList.add(new Dog("22",22));
        arrayList.add(new Dog("23",23));

        for (Object o : arrayList) {
            System.out.println( ((Dog) o).getName());
        }

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("21",21));
        dogs.add(new Dog("21",213));
        dogs.add(new Dog("221",21));
        for (Dog o : dogs) {
            System.out.println(o.getName());
        }


    }
}

class Dog{
    public String name;
    public int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
