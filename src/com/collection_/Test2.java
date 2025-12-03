package com.collection_;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {

        List list = new ArrayList();
        //1.有序的 添加顺序 取出顺序是一致的 元素可以重复
        list.add("23");
        list.add("@31");
        System.out.println(list);
        //2.支持索引
//        System.out.println(list.get(1));

        list.add(1,"3333");
        System.out.println(list);
        List list2 = new ArrayList();
        list2.add("334455");
        list2.add("666");
        list.addAll(1,list2);
        System.out.println(list);
        int i = list.indexOf("@31") ;
        System.out.println(i);
        int ii = list.lastIndexOf("@31");
        System.out.println(ii);
        Object o = list.remove(4);
        System.out.println(o);
        System.out.println(list);
        //替换
        list.set(1,"54345434");
        System.out.println(list);
        //返回范围内的集合
        List p = list.subList(0,3);
        System.out.println(p);


    }
}
