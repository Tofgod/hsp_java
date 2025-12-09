package com.collection_.set;

import java.util.HashSet;
import java.util.Objects;

public class HashSet02 {
    public static void main(String[] args) {
        //1.hashset 底层是 hashmap
        //2.新增一个值的时候 先生成这个值的hash值 在通过hash值结合算法生成索引值 来决定放在数组的什么索引位置
        //3.找到该位置后 看table数组该位置是否有值 没值就放
        //4.有值 就使用equals 进行比较 如果相同 就不放入  不相同就加入到后面
        //5.java8中 如果一个链表的元素到8 并且table的大小到达默认64  就会进行树化  （红黑树）
        //6.扩容机制 第一次添加扩容到16 加载因子*0.75 达到加载因子 就进行扩容 16*2 扩容到32  在32的基础上达到0.75 继续进行乘2扩容
        //7.扩容 跟扩容因子比较的是 加入的node节点的数量 并不是非得table的索引达到12


        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println(hashSet);

        hashSet.add(new Emo("das" , 18 , new MyB("2","3","2")));
        hashSet.add(new Emo("das" , 18 , new MyB("2","3","2")));
        System.out.println(hashSet);

    }
}

class MyB{
    private String y;
    private String m;
    private String d;

    public MyB(String m, String d, String y) {
        this.m = m;
        this.d = d;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyB)) return false;
        MyB myB = (MyB) o;
        return Objects.equals(y, myB.y) && Objects.equals(m, myB.m) && Objects.equals(d, myB.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, m, d);
    }

    @Override
    public String toString() {
        return "MyB{" +
                "y='" + y + '\'' +
                ", m='" + m + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}

class Emo{
    private String name;
    private int age;
    private MyB myb;

    public Emo(String name, int age, MyB myb) {
        this.name = name;
        this.age = age;
        this.myb = myb;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Emo)) return false;
        Emo emo = (Emo) o;
        return age == emo.age && Objects.equals(name, emo.name) && Objects.equals(myb, emo.myb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, myb);
    }

    @Override
    public String toString() {
        return "Emo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", myb=" + myb +
                '}';
    }
}
