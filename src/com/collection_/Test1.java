package com.collection_;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
    public static void main(String[] args) {
        //遍历元素   Iterator 迭代器
        ArrayList arrayList = new ArrayList();

        arrayList.add(new Book("das",10));
        arrayList.add(new Book("We",3));

        System.out.println(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()){  //判断还有没有
            Object next = it.next(); //返回下一个元素 类型是 Object
            System.out.println(next);  //输出的元素
        }

        //当退出While 退出循环以后 iterator迭代器会指向最后一个元素 继续执行会抛出异常
//        it.next();
        //如果要再次遍历 则要重置迭代器 it = arrayList.iterator();//

        for (Object obj : arrayList){
            System.out.println(obj);
        }
        // 底层还是 迭代器 仍然是迭代器



    }
}

class Book{
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
