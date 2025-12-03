package com.data_;

import java.util.Calendar;

public class Test2 {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance(); //抽象类
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        //可变性 偏移行  年从1900开始 月从0开始 格式化只对data有用 无格式化方法 存在线程安全 。每隔两天多出1S

    }
}
