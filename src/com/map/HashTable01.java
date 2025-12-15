package com.map;

import java.util.Hashtable;

public class HashTable01 {
    public static void main(String[] args) {

        Hashtable hashtable = new Hashtable();
        // 1. 键值不能为null 会跑异常 线程安全的
        // 2.hashtable(synchronized)线程安全的  hashmap 线程不安全
        // 3.初始化数组大小为11
        // 4. 当数量大于等于临界值  进行扩容 *2+1  2n+1、
        hashtable.put("1",1);


    }
}
