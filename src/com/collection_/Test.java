package com.collection_;





import java.util.*;

public class Test {
    public static void main(String[] args) {
        @SuppressWarnings({"all"}) //警告抑制
        //集合 动态保存任意多个对象
        // 1. 集合分为 单列集合  双列集合

        // add remove set get

        //单列集合
        // Iterable -> Collection -> 子接口 List  Set
        //List -> 子类 ArrayList Vector LinkedList
        //Set -> 子类 HashSet TreeSet

        //双列集合
        //Map  -> 子类  HashMap Hashtable TreeMap
        //Hashtable -> 子类Properties
        //HashMap ->子类 LinkedHashMap

        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");

        HashMap hashMap = new HashMap();
        hashMap.put("1","1");
        hashMap.put("2","2");

        List List = new ArrayList();
        List.add("jack");
        List.add(10); // 自动装箱
        List.add(true);
        System.out.println(List);
        List.remove("jack");
//        List.remove(0);
        System.out.println(List);
        System.out.println(List.contains("jack"));
        System.out.println(List.size());
        System.out.println(List.isEmpty());
//        List.clear();//清空
        System.out.println(List);
        List List1 = new ArrayList();
        List1.add("tom");
        List.addAll(List1);
        System.out.println(List);
        System.out.println(List.containsAll(List1));
        List.add("21341");
        List.removeAll(List1);
        System.out.println(List);



    }
}
