package com.collection_.set;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet01 {
    public static void main(String[] args) {
        // 可以排序
        // 可以传入一个比较器 用于指定排序
        //底层是Treemap
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String)o2) ;
            }
        }); //使用红黑树来存储元素
        treeSet.add("123");
        treeSet.add("456");
        treeSet.add("12453");
        treeSet.add("45676");

        System.out.println(treeSet);
    }
}
