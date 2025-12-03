package com.string_;

public class Test06 {
    public static void main(String[] args) {


        // StringBuilder 不是线程安全的
        // StringBuilder 是 StringBuffer 的简易替换  在单线程的时候使用  这个比StringBuffer要快
        // StringBuilder 重载了append insert
        // 继承AbstractStringBuilder 初始化为16个字符
        // 实现了 Serializable 可以串行化 所以可以网络传输 可以保存到文件
        // final类 不能被继承 字符序列数据是放在父类 AbstractStringBuilder的char[] value 数据也是在堆里面
        // synchronized 是 Java 中的一个关键字，用于实现线程同步。它可以确保在同一时刻，
        // 只有一个线程可以执行被 synchronized 修饰的方法或代码块，从而避免线程间的竞争和数据不一致的问题

        StringBuilder stringBuilder = new StringBuilder();

        // String StringBuffer StringBuilder 比较
        // 1. 均可以字符序列化 方法也是一样的 继承的类是一样的
        // 2. String 不可变序列 效率低 复用率高 是在常量池中取值
        // 3. StringBuffer 线程安全 StringBuilder 线程不安全 都是可变序列 效率高  StringBuilder比StringBuffer要效率高

        //如果需要对 String 进行大量修改 不使用String

        //效率比较





    }
}
