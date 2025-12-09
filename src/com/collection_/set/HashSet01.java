package com.collection_.set;

import java.util.HashSet;

public class HashSet01 {
    public static void main(String[] args) {

        //本质是一个 hashmap 构造器new了一个hashmap 赋值给map
        HashSet hashSet = new HashSet();
        hashSet.add(null);
        hashSet.add(null);
        System.out.println(hashSet.add(1));
        System.out.println(hashSet.add(null)); //返回一个布尔 是否添加成功
        //不保证存放的顺序跟取出的顺序是一致的
        hashSet.add(new Dog("2"));
        hashSet.add(new Dog("2"));

        hashSet.add(new String("21")); //t
        hashSet.add(new String("21")); //f 加入不了
        System.out.println(hashSet);

        //hashset的底层其实是hashmap
        //数组 链表 红黑树 实现 hashmap
        //每一个数组 都是一个node 是一个链表的开端
        //每一个数组上的位置都会存放一条链表 当链表的数量达到上限 就会变成红黑树


        // 称为table 16
        Node[] table = new Node[16];

        Node tom = new Node("tom");
        table[2] = tom;
        Node jack = new Node("jack");
        tom.next = jack;
        Node bob = new Node("bob");
        jack.next = bob;


    }
}

class Node{

    public Object item;
    public Node next;

    public Node(Object item) {
        this.item = item;
    }
}

class Dog{
    public String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
