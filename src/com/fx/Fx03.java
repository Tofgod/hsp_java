package com.fx;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Fx03 {
    public static void main(String[] args) {
        //泛型只能是引用类型
        //指定泛型的类型后 可以传入子类
        //指定了泛型 不写的话 默认是object

        ArrayList<Emo> emos = new ArrayList<>();
        emos.add(new Emo("das", 1000, new MyDate(2001, 10, 13)));
        emos.add(new Emo("das", 1000, new MyDate(2002, 11, 13)));
        emos.add(new Emo("das", 1000, new MyDate(2003, 9, 13)));
        emos.sort(new Comparator<Emo>() {
            @Override
            public int compare(Emo o1, Emo o2) {
                if (o1.getName().equals(o2.getName())){
                    return o1.getB().compareTo(o2.getB());
                }else{
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(emos);

    }
}

class Emo{
    private String name ;
    private int sal;
    private MyDate B;

    public Emo(String name, int sal, MyDate b) {
        this.name = name;
        this.sal = sal;
        B = b;
    }

    public MyDate getB() {
        return B;
    }

    public void setB(MyDate b) {
        B = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Emo{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", B=" + B +
                '}';
    }
}

class MyDate implements Comparable<MyDate>  {
    private int Y;
    private int M;
    private int D;

    public MyDate(int y, int m, int d) {
        Y = y;
        M = m;
        D = d;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "Y='" + Y + '\'' +
                ", M='" + M + '\'' +
                ", D='" + D + '\'' +
                '}';
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    @Override
    public int compareTo(MyDate o) {
        return this.Y == o.getY() ? (this.M == o.getM() ? this.D - o.getD() : 0  ) : this.Y - o.getY()  ;
    }
}
