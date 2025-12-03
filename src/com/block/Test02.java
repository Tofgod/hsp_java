package com.block;

public class Test02 {

    public static void main(String[] args) {


        //单例模式有8种
        SingleTon.getInstance();
        SingleTonC.getInstance();



    }
}


//单例设计模式  饿汉式 可能造成未使用 资源浪费  存在浪费资源的问题
class SingleTon{

    private SingleTon() {}

    //静态方法中使用
    private static SingleTon instance = new SingleTon();

    public static SingleTon getInstance(){
        return instance;
    }

}

//单例设计模式 懒汉式  //存在线程安全的问题  如果同时三个线程同时进行
// getInstance 调用 就会被创建3次 单例模式就会被破坏 线程安全问题
class SingleTonC{

    private SingleTonC() {}

    //静态方法中使用
    private static SingleTonC instance;

    public static SingleTonC getInstance(){
        if (instance == null){
            return instance = new SingleTonC();
        }else{
            return instance;
        }
    }

}
