package com.map;

import java.util.HashMap;
import java.util.Map;

public class Map01 {
    public static void main(String[] args) {
        //map
        //1.map跟collection并列存在 key-value 双列元素
        //2.map 的key value 可以存放任何数据 包括null
        //3.key重复的情况下value会被替换  不会创建相同的key   value可以重复、  无序的
        //4.常用string作为key
        //5.一个key对应一个value 单向对应

        // node节点 继承了map的entry


        Map hashMap = new HashMap();
        hashMap.put("a","b");
        hashMap.put("r",1);
        hashMap.put("r",null);
        hashMap.put("r",'l');
        System.out.println(hashMap);
        System.out.println(hashMap.get("r"));


    }
}
