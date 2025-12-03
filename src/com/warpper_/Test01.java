package com.warpper_;

public class Test01 {
    public static void main(String[] args) {

        //Boolean
        //Character

        //继承Number
        //Byte
        //Short
        //Integer
        //Long
        //Float
        //Double

        //基本数据类型 到 包装类型 就是装箱


        //自动装箱拆箱 底层调用的是vauleof

        //jdk 5 以前装箱
        int a = 1;
        Integer a1 = new Integer(a); //手动装箱
        Integer a11 = Integer.valueOf(a);//手动装箱
        //jdk 5 以前拆箱
        int a2 = a1.intValue(); // intValue 手动拆箱

        //jdk5 以后  自动装箱 自动拆箱
        int b = 100;
        Integer n = b; //自动装箱 底层调用的是Integer.valueOf(a);

//        public static Integer valueOf(int i) {
//            if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
//                return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
//            return new Integer(i);
//        }

        //jdk5 以后  自动拆箱
        int n2 = n;
//        底层自动执行 intValue 方法
//        public int intValue() {
//            return value;
//        }

        //其他包装类型类似
    }
}

