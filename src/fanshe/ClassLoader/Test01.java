package fanshe.ClassLoader;

import fanshe.Car;

public class Test01 {
    public static void main(String[] args) {

        Car car = new Car();
    }
}
class B{
    // 链接 准备阶段
    public  int a = 1;  // 是实例属性 不分配内存
    public static  int b = 2; // 静态变量 分配内存 不分配值
    public static final  int c = 3;// 常量 分配内存 分配值
    //链接阶段 解析
    // 虚拟机将常量池的符号引用替换为直接引用
}