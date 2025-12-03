package com.string_;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String passWord = scanner.next();
        System.out.println("请输入邮箱：");

    }
}

class Tool{
    public static void res(String name, String pwd, String email){
        if (!((name .length() >= 2) && (name .length() <= 4))){
            throw new RuntimeException("用户名长度为2或3或4");
        }
        if (!(pwd.length() == 6 && vN(pwd))){
            throw new RuntimeException("密码是6位且必须是数字");
        }

        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > -1 && j > -1 && i < j)){
            throw new RuntimeException("邮箱必须包含@以及. 且@在.的前面");
        }

        System.out.println("注册成功");

    }
    public static boolean vN(String str){
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar < '0' || aChar > '9') {
                return false;
            }
        }
        return true;
    }
}
