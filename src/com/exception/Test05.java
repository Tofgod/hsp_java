package com.exception;


import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {

        System.out.println(args[4]);
        Scanner scanner = new Scanner(System.in);
        String  num1 = scanner.next();
        String  num2 = scanner.next();


        try {
            int N1 = Integer.parseInt(num1);
            int N2 = Integer.parseInt(num2);

            if (N2 == 0){
                throw new ArithmeticException();
            }

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("N2 == 0");
        }finally {

        }
    }


    public static void cal(int n , int m ){
        try {
            int a = n / m ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

//自定义异常 继承 RuntimeException
class AException extends RuntimeException{

    public AException(String message) {
        super(message);
    }

}
