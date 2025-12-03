package com.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class Test03 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Wqe",100);
        books[1] = new Book("Wqe11",80);
        books[2] = new Book("Wqe222",120);
        books[3] = new Book("Wqe3333",30);

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
//                return (int)(b1.getAge() - b2.getAge());
//                return (int)(b2.getAge() - b1.getAge()); // 有漏洞 最好求正负值 以及 0
//                return (int)(b2.getName().length() - b1.getName().length());
                return (int)(b1.getName().length() - b2.getName().length());
            }
        });

        for (Book b : books) {
            System.out.println(b.getName());
        }
    }
}


class Book{

    private String name ;
    private double age ;

    public Book(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


