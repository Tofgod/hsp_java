package com.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Collection02 {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        Car c = new Car("das" , 1);
        arrayList.add(c);
//        arrayList.remove(c);
        System.out.println(arrayList.contains(c));
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        arrayList.clear();
        System.out.println(arrayList);

        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(c);
        arrayList.addAll(arrayList1);
        System.out.println(arrayList);

        System.out.println(arrayList.containsAll(arrayList1));
        System.out.println(arrayList.removeAll(arrayList1));
        System.out.println(arrayList);

        arrayList.add(c);
        arrayList.add(c);arrayList.add(c);arrayList.add(c);

//        for (Object o : arrayList) {
//            System.out.println(o);
//        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);

        }




    }
}

class Car {
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
