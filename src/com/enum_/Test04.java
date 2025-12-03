package com.enum_;

public class Test04 {
    public static void main(String[] args) {
        Week [] week = Week.values();
        for (Week we : week){
            System.out.println(we.getName());
        }
    }
}

//使用了enum 无法继承其他类  enum隐的式继承了 Enum
//可以实现接口

enum Week implements A {
    MON("星期一"),TUS("星期二"),WED("星期三"),
    THU("星期四"),FRI("星期五"),SAT("星期六"),
    SUN("星期日");

    private String name ;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public void a() {

    }
}

interface A{
    void a();
}



