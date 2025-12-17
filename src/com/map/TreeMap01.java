package com.map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap01 {
    public static void main(String[] args) {

        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2 ) ;
            }
        });

        //默认按照 compareTo

        treeMap.put("jack","1");
        treeMap.put("tom","2");
        treeMap.put("bob","3");
        treeMap.put("no","4");
        treeMap.put("yes","5");

        System.out.println(treeMap);





    }
}
