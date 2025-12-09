package com.collection_.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set01 {
    public static void main(String[] args) {
        //Set
        //无序 没有索引 元素不可以重复  最多包涵一个null
        //不可以用索引进行遍历 是无序的
        //取出的顺序不是添加的顺序  但取出的顺序是固定的

        Set hashSet = new HashSet();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add(null);
        hashSet.add(null);
        //自动去重
        System.out.println(hashSet); //添加的顺序跟取出来的顺序 不一样 但是是固定的
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
//        for (Object o : hashSet) {
//            System.out.println(o);
//        }

    }
}
