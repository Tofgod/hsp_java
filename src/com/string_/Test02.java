package com.string_;

import java.util.Arrays;

public class Test02 {
    public static void main(String[] args) {
        String s = "good hello";
        System.out.println(s.charAt(0));
        System.out.println(s.substring(5));
        System.out.println(s.substring(0,4)); //截取到索引4的前一个


        String s1 = "@1321";
        s1 = s1.concat("Wqe");
        System.out.println(s1);
        s1 = s1.replace("1","2131321");
        System.out.println(s1);


        String name = "231,32131,32131,3213,13,21";
        String[] nam = name.split(",");
        System.out.println(Arrays.toString(nam));

        String p = "E:\\aaa\\bbb";
        nam = p.split("\\\\"); //对于 \ 等特殊字符 要进行转译 \\
        System.out.println(Arrays.toString(nam));

        char[] c = s1.toCharArray(); //传唤成字符数组
        System.out.println(Arrays.toString(c));


        String aa = "jack";
        String bb = "jac";
        System.out.println(aa.compareTo(bb));   //看源码 是单个字符的比较

    }
}
