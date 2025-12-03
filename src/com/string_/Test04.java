package com.string_;


public class Test04 {
    public static void main(String[] args) {



        // StringBuffer  可以改变字符序列 对内容进行增删  是可变长度 是一个容器
        // StringBuffer stringBuffer = new StringBuffer("hello");  //继承AbstractStringBuilder 初始化为16个字符
        // 继承AbstractStringBuilder 在父类中 有一个 char[] value;
        // 不是finial 存放字符串内容 在父类的 char[] value; 是存放在堆中的 不存放在常量池中
        // 当 char[] value 是存放在堆中的 值进行更新时 每次不更换地址 直接改变堆中的值
        // 空间不够时 创建新的更大的空间 进行数据存储 所以效率高于 String
        // String 值每次变化 直接在常量池进行创建 更换地址指向

        //默认创建一个大小为16的char数组
        StringBuffer stringBuffer = new StringBuffer();
        //指定创建一个大小为100的char数组
        StringBuffer stringBuffer1 = new StringBuffer(100);
        //创建一个 hello 的长度 加上16的长度 的char数组 21
        StringBuffer stringBuffer2 = new StringBuffer("hello");


        //String  StringBuffer 相互转换
        String s1 = "hello";
        StringBuffer stringBuffe3 = new StringBuffer(s1);
        System.out.println(stringBuffe3);
        stringBuffe3.append("hello");
        System.out.println(stringBuffe3);


        StringBuffer stringBuffe4 = new StringBuffer(s1);
        String s2 = stringBuffe4.toString();
        System.out.println(s2);
        String s3 = new String(stringBuffe4);
        System.out.println(s3);






    }
}
