package com.data_;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class Test3 {
    public static void main(String[] args) {
        //jdk8 localData 年月日 localTime十分秒 localDataTime都有
        LocalDateTime data = LocalDateTime.now();
        System.out.println(data);
        System.out.println(data.getYear());
        System.out.println(data.getMonthValue());

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss E");
        String str =  f.format(data);
        System.out.println(str);

        //时间戳
        Instant i = Instant.now();
        Date date = Date.from(i);
        Instant c = date.toInstant();
        System.out.println(i);
        System.out.println(date);
        System.out.println(c);

        //plus minus 加减
        LocalDateTime v = LocalDateTime.now();
        LocalDateTime v1 = v.plusYears(1);
        System.out.println(v1);
        LocalDateTime v2 = v.plusDays(100);
        System.out.println(v2);





    }
}
