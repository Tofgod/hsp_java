package com.innerClass;

public class Test05 {
    public static void main(String[] args) {

        //外部其他类 使用成员内部类
        //1.
        Pp pp = new Pp();
        Pp.Cc c = pp.new Cc();
        //2. 外部类写一个方法 返回这个对象
        //3.

        Pp.Dd dd = new Pp.Dd();
        dd.gg();

        Pp.Dd dd1 = new Pp().getInner();
    }
}
//成员内部类

class fff{
    static int a ;
}


class Pp{

    static private int a ;

    //成员内部类
    class Cc{
        private  int a = 4;

        public void aa(){
            System.out.println(a);
            System.out.println(Pp.this.a);  //访问外部类的重名属性
        }

    }

    //遵循static 的访问规则。可以访问外部类的静态成员 不能访问非静态成员、
    static class Dd{
        public void gg(){
            System.out.println(a);
        }

        public static void a(){

        }


    }

    public void a(){
        Cc cc = new Cc();
        Dd dd = new Dd();

        Dd.a();
    }

    public Dd getInner(){
        return new Dd();
    }

}