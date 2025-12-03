package com.innerClass;


public class Test04 {
    public static void main(String[] args) {
        f1(new Ac(){
            @Override
            public void show() {

            }
        }); //传入一个匿名内部类

        Phone phone = new Phone();
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴 上课了");
            }
        });

        //继承 动态绑定 多态





    }

    static void f1(Ac ac){
        ac.show();
    }
}

//实践  匿名内部类当一个实参数

interface Ac{
    void show();
}

interface Bell{
    void ring();
}

class Phone {
    public void alarmClock(Bell bell){
        bell.ring();
    }
}
