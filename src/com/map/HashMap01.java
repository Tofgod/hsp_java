package com.map;

import java.util.HashMap;

@SuppressWarnings({"all"})
public class HashMap01 {
    public static void main(String[] args) {

        //扩容机制 扩容因子 0.75 扩容倍数 2
        HashMap hashMap = new HashMap();
        hashMap.put("1","123");
        hashMap.put("2","456");
        hashMap.put("1","789");
        System.out.println(hashMap);

        //1. new HashMap 初始化 加载因子  初始化node  HashMap$Node[]
        //2. put -> putVal  hash计算 得出存放在table的索引
        //3.判断当前索引十分有值 没值 直接放 有值进行便利看是否key重复  如果重复替换value
        //4.如果不重复 加入进去 加入需要判断 是否红黑树 链表
        //5.删除的时候 数据量变少的时候 红黑树会剪枝 直到变成链表


    }
}
