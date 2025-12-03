package com.exception;


import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String  a = "";
        int b ;
        while (true){
            try {
                a = scanner.next();
                b = Integer.parseInt(a);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是一个整数");
            } finally {

            }
        }

        System.out.println(b);
    }
}

