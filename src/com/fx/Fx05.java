package com.fx;

public class Fx05 {
    public static void main(String[] args) {
        N.aa("a");
    }
}


//泛型方法
class N{

    //
    public static  <T> void aa(T t){
        System.out.println(t.getClass());
    }
}

class Nt <M>{

    //泛型方法
    public  <T> void aa(T t , M m){
        System.out.println(t.getClass());
    }

    //方法使用了泛型
    public  void aaq(M t){
        System.out.println(t.getClass());
    }
}
