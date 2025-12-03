package com.warpper_;

public class Test02 {
    public static void main(String[] args) {
        //三元运算符 看作一个整体 精度提升
        Object a = true ? new Integer(1) : new Double(2);
        //a 的精度会提升 输出 1.0
        System.out.println(a);

        //包装类型跟St类型转换

        Integer i = new Integer(1);
        //转换成字符串
        // 方式1
        String r = i + "" ;
        //～2
        String r2 =  i.toString();
        String r3 = String .valueOf(i);

        //字符串转数字
        String r4  = "2131";
        Integer t = Integer.parseInt(r4); //自动装箱
        Integer i1 = new Integer(r4); //构造器

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Character.isDigit('1'));






    }
}
