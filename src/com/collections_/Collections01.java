package com.collections_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Collections01 {

    public static void main(String[] args) {
        //工具类 操作 set list map
        ArrayList arrayList = new ArrayList();
        arrayList.add("tom0");
        arrayList.add("tom11");
        arrayList.add("tom222");
        arrayList.add("tom0");

        //反转
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        //随机打乱顺序
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
        //升序
        Collections.sort(arrayList);
        System.out.println(arrayList);
        //指定排序规则
        Collections.sort(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o2).length() -  ((String) o1).length() ;
            }
        });
        System.out.println(arrayList);

        //指定位置元素交换
        Collections.swap(arrayList , 0 , 1);
        System.out.println(arrayList);

        //max
        Object o = Collections.max(arrayList);
        System.out.println(o);
        Object o1 = Collections.max(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o2).length() -  ((String) o1).length();
            }
        });
        System.out.println(o1);

        // min
        Object o2 = Collections.min(arrayList);
        System.out.println(o2);
        Object o3 = Collections.min(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o2).length() -  ((String) o1).length();
            }
        });
        System.out.println(o3);

        //元素出现的次数
        System.out.println(Collections.frequency(arrayList,"tom0"));

        //copy
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("44");
        arrayList1.add("43");
//        arrayList1.add("55");
//        arrayList1.add("74");
//        arrayList1.add("04");
        Collections.copy(arrayList , arrayList1 );
        //  arrayList1的长度 不能超过  arrayList 的长度
        System.out.println(arrayList);

    }

}
