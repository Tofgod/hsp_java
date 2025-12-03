package com.enum_;

public class Test03 {

    public static void main(String[] args) {
        System.out.println(G5.boy.name()); //输出枚举对象常量的名称
        System.out.println(G5.girl.ordinal()); //输出的是该枚举的顺序
        System.out.println(G5.values()[0]); //返回的是一个枚举数组


        //增强for
        for (G5 g : G5.values() ){
            System.out.println(g);
        }
        // valueOf 将变量转换为对象
        // boy根据boy去查找 找到了 就返回 找不到就报错
        G5 aa = G5.valueOf("boy");
        System.out.println(aa);
        System.out.println(aa  == G5.boy);
        // compareTo 比较位置号 girl 的编号 跟 boy 的编号去比较
        // 结果是 boy 的编号减去 girl 的编号 前减后 0 - 1 = -1;
        System.out.println(G5.boy.compareTo(G5.girl));



        //匿名内部类
        new CCC().b(new ar (){
            @Override
            public void a() {
                System.out.println("dewnjfkenwi");
            }
        });

    }
}


enum G5{
    boy,girl;

}

class CCC{

    public void a(){

        ar c = new ar(){
            @Override
            public void a() {

            }
        };

    }

    public void b(ar a ){
        a.a();
    }




}

interface ar {
    void a ();
}