package com.exercise;

import java.util.*;

public class Map01 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack",650);
        hashMap.put("tom",1200);
        hashMap.put("smith",2900);

        hashMap.put("jack",2600);

        Set set = hashMap.keySet();
        for (Object o : set) {
            System.out.println(o);
            hashMap.put( o , (int )hashMap.get(o) + 100);
        }

        Collection values = hashMap.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        Set set1 = hashMap.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            Map.Entry next = (Map.Entry) iterator1.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());

        }


        //分析 treeset  是怎么去重的  根据传入的比较器是否为0进行去重的
        //hashset 去重  根据hashcode equals 进行比较的

        TreeSet treeSet = new TreeSet();
        // 源码分析  这个类没有实现 Comparable 这个接口 也没有传入 Comparable  匿名内部类
        // 而add的时候 会将key转成Comparator类型  所以会报错
        // TreeSet 只能存放可以互相比较的数据 同一种数据
        treeSet.add(new Person());
//        treeSet.add("21");


    }
}

class Person implements Comparable {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

