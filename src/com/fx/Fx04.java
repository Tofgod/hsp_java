package com.fx;

public class Fx04 {
    public static void main(String[] args) {
        //泛型类的泛型是在创建对象的时候确认的 在创建对象的时候指定泛型的类型 如果没有指定默认是 Object
        //静态方法不能使用泛型类
        //泛型数组不能够初始化  // 因为类型无法确定下来 所以 不可以初始化

        //静态方法属性不能使用泛型

        //泛型接口在继承的时候 确定类型
    }
}

class Tigger<T>  {
    T []t; // 泛型数组不能够初始化  // 因为类型无法确定下来 所以 不可以初始化

//    public static T aa(){
//        return T ;
//    }
    //静态方法在类加载时使用 但是对象还没有创建 所以无法确认泛型的类型 所以无法使用
}

//接口的属性都是静态的 所以不可以使用泛型 方法可以
interface A<T>{

    // T a;
    public void a(T t);

    static void b (){

    }

}

interface B extends A<String>{    // 是这样继承的

}

class v implements A<String>{
    @Override
    public void a(String s) {

    }
}

class Bb implements B{
    @Override
    public void a(String s) {

    }
}


