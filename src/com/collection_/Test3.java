package com.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Test3 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //结论 1.arraylist维护了一个对象类型的数组 elementData Object类型的数组
        //2.当创建 ArrayList 使用无参构造器 初始化elementData容量为0 add一次 扩容为10 再次add 则扩容为1.5倍
        //3.如果使用指定大小的构造器 则elementData容量为指定的大小 add一次 扩容1.5倍
        // transient 关键字 表示瞬间  如果被此修饰 该属性不被序列化

        //debug 默认情况下的显示信息是简化过的 要看全部的需要做设置

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= 10; i++) {
            arrayList.add(i);
        }
        for (int i = 11; i <= 15 ; i++) {
            arrayList.add(i);
        }
        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(null);

        ArrayList arrayList1 = new ArrayList(10); // 扩容为10 add 则扩容为1.5倍


        Vector vector = new Vector();
        // 底层是对象数组 可变数组
        // 线程安全  效率不高  如果是无参 默认10 每次扩大2  指定大小 每次扩大2
        for (int i = 0; i <= 10; i++) {
            vector.add(i);
        }

    }
}
