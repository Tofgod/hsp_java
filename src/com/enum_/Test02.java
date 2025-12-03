package com.enum_;

public class Test02 {
    public static void main(String[] args) {
        System.out.println(Se.S.getName());
        System.out.println(G.boy);
    }
}



//enum
//默认继承  Enum sout 会调用Enum 的tostring
//使用javap 生成反编译文件 反编译的问价内容
//final class com.enum_.Se extends java.lang.Enum<com.enum_.Se> {
//    public static final com.enum_.Se S;
//    public static final com.enum_.Se W;
//    public static com.enum_.Se[] values();
//    public static com.enum_.Se valueOf(java.lang.String);
//    public java.lang.String toString();
//    static {};
//}

enum G{
    boy,girl;
}



enum Se{

    S("2131","213112"),  //常量名 参数列表  如果有多个使用,间隔
    W("2323","231321"),
    T;
    //常量写在最前面

    //枚举类的常量 在最上面 变量放在下面
    private String name ;
    private String desc ;

    private Se(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    private Se() {

    }

    @Override
    public String toString() {
        return "Se{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}