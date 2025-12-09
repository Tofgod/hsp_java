package com.collection_;

import java.util.Iterator;
import java.util.LinkedList;
@SuppressWarnings("all")
public class LInkedList02 {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        //增 删 改 查  crud

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove(); //默认删除第一个
//        linkedList.remove(1);

        linkedList.set(1,999);
        linkedList.get(1);

        System.out.println(linkedList);
        System.out.println(linkedList.get(1));

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        for (Object o : linkedList) {
            System.out.println(o);
        }

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }


    }
}
