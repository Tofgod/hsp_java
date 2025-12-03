package com.enum_;

public class Test01 {
    public static void main(String[] args) {
        System.out.println(Sea.S);
    }
}

//只读的不可修改的一些固定的值
//两种
// 自定义枚举 大写

class Sea{
    private String name ;
    private String dec;

    //加入final优化
    public final static Sea  S = new Sea("1","1");
    public static Sea  W = new Sea("1","1");
    public static Sea  p = new Sea("1","1");
    public static Sea  A = new Sea("1","1");


    private Sea(String name, String dec) {
        this.name = name;
        this.dec = dec;
    }


    @Override
    public String toString() {
        return "Sea{" +
                "name='" + name + '\'' +
                ", dec='" + dec + '\'' +
                '}';
    }
}