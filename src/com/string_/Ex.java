package com.string_;

import java.util.Arrays;

public class Ex {
    public static void main(String[] args) {
        String st = "abcdef";
        String newSt = Tools.reverse(st,1,4);
        System.out.println(newSt);
        try {
            Tools.reverse(null,0,0);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }

    }
}

class Tools{

    public static String reverse(String str , int start , int end){

        if ((str == null) || (end > str.length()) || (start < 0) || (end <= start)){
            throw new RuntimeException("参数错误");
        }

        char[] strArr = str.toCharArray();

//        while (true){
//            char temp = strArr[start];
//            strArr[start] = strArr[end] ;
//            strArr[end] = temp;
//            start++;
//            end--;
//            if (start > end){
//                break;
//            }
//        }

        for (int i = start ,j = end ; i < j ; i++ , j--){
            char temp = strArr[i];
            strArr[i] = strArr[j] ;
            strArr[j] = temp;
        }

        System.out.println(Arrays.toString(strArr));

        return new String(strArr);
    }
}
