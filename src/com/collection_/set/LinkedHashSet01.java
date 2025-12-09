package com.collection_.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSet01 {
    public static void main(String[] args) {
        //属于 hashset的一个子类
        //底层是 linkedhashmap  linkedhashmap 是 hashmap的一个子类 底层维护了一个数组加一个双向链表 那就是有序的
        //用链表维护元素的秩序 使得元素看起来是以插入的顺序来保存的
        //不允许添加重复元素
        // 每一个节点拥有 next pre 属性
        // add 添加的时候 会先计算hashcode 再获得索引值 插入到数组 进行重复比较 相同则不添加 不同 就添加 同时绑定到双向链表
        Set linkedHashSet = new LinkedHashSet();

        linkedHashSet.add(1);
        linkedHashSet.add(5);
        linkedHashSet.add("213");
        linkedHashSet.add("null");

        System.out.println(linkedHashSet);


    }
}
