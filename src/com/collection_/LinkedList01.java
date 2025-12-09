package com.collection_;

import java.util.LinkedList;

public class LinkedList01 {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        // 实现了双向链表 和 双端队列的特点  //可以添加任何元素 包括null  线程不安全 没有实现同步
        // 底层维护了一个双向链表
        //源码解析 存在 first last 字段 first指向维护的链表的第一个元素  last指向维护的链表的最后一个元素
        //每一个节点是一个node对象 有三个属性prev next item
        //linklist 不是通过数组进行操作 元素的添加以及删除效率是比较高的
        //

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node abc = new Node("abc");


        jack.next = tom;
        tom.prev = jack;
        tom.next = abc;
        abc.prev = tom;

        Node sms = new Node("sms");

        tom.next = sms;
        abc.prev = sms;

        sms.prev = tom;
        sms.next = abc;

        Node first = jack;
        Node last = abc;

        while (true){
            if (last == null){
                break;
            }
            System.out.println(last);
            last = last.prev;
        }




    }
}

class Node{
    public Object item;
    public Node prev;
    public Node next;

    public Node(Object o ){
        this.item = o ;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
