package com.data_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        Date date1 = new Date(21313131); //毫秒
        System.out.println(date.getTime());
        System.out.println(date1.getTime());


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:dd E");
        String str =  simpleDateFormat.format(date);
        System.out.println(str);
        Date p = simpleDateFormat.parse("2025年11月26日 10:34:26 星期三"); // 格式要正确 格式需要跟simpleDateFormat定一个的格式匹配
        System.out.println(p);
    }
}
