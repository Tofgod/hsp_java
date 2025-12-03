package collection;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        System.out.println(arrayList);
        //底层是数组来实现的
        //  ArrayList 基本等同于 Vector 除了线程不安全 执行效率高 多线程情况下不建议使用
        //没有加线程安全关键字 synchronized
    }
}
