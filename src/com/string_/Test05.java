package com.string_;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("hello").append(true);
        System.out.println(stringBuffer);

        stringBuffer.delete(0,1); //删除 包括0不包函1的索引的字符
        System.out.println(stringBuffer);

        stringBuffer.replace(0,1,"1");
        System.out.println(stringBuffer);

        System.out.println(stringBuffer.indexOf("1"));

        stringBuffer.insert(0,"22222");//在索引0之前插入22222
        System.out.println(stringBuffer);

        System.out.println(stringBuffer.length());

        String str = null;
        stringBuffer.append(str);
        System.out.println(stringBuffer);

        System.out.println(str);
        //StringBuffer stringBuffer1 = new StringBuffer(str);//抛出异常 null.length() 抛出空指针异常
        //System.out.println(stringBuffer1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品名");
        String str1 = scanner.next();
        System.out.println("请输入价格");
        String str2 = scanner.next();
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1.append("商品名").append("\t").append("商品价格").append("\n").append(str1).append("\t");

        int inx = str2.indexOf(".");
        int insert = 0;
        int count = 0 ;
        StringBuffer stringBuffer2 = new StringBuffer(str2);
        if (inx == -1 ){
            insert = str2.length() ;
            count = str2.length() / 3;
        }else{
            insert = inx  ;
            count = inx / 3;
        }

        for (int i =  0 ; i < count ; i++) {
            if (insert <= 3){
                break;
            }
            insert -= 3;
            stringBuffer2.insert(insert,",");
        }
        stringBuffer1.append(stringBuffer2.toString());
        System.out.println(stringBuffer1);

    }
}
