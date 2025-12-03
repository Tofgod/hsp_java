package com.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class Test01 {
    public static void main(String[] args) {

        Integer [] ints = {3,2,6,4,5};
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        //传入  实现了Comparator接口的匿名内部类 Comparator
        Arrays.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1 ;
            }
        });

        System.out.println(Arrays.toString(ints));

        int [] arr = {1,-4,6,2,90,5,3};
        Arr.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arr.sort01(arr , new Comparator <Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr));


    }
}

class Arr{

    public static void sort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //从小到大
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp ;
                }
            }
        }
    }

    public static void sort01(int[] arr , Comparator c){
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //从小到大
                if (c.compare(arr[j] , arr[j + 1]) > 0){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp ;
                }
            }
        }
    }

    public static void sort01(Book[] arr , Comparator c){
        Book temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //从小到大
                if (c.compare(arr[j] , arr[j + 1]) > 0){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp ;
                }
            }
        }
    }
}
