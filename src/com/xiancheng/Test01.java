package com.xiancheng;

import org.omg.SendingContext.RunTime;

public class Test01 {
    public static void main(String[] args) {
        // 线程由进程创建  一个进程可以创建多个线程
        //单线程  多线程  并发 同一时刻多个任务交替执行  并行 同一时刻 多个任务同时执行

        Runtime runtime = Runtime.getRuntime();
        int cpuNums = runtime.availableProcessors(); //可获得的处理器
        System.out.println(cpuNums);

        //继承 Thread 重新run

        Cat cat = new Cat();
        cat.start();//启动线程  // start 调用start0 该线程不会立即执行 由cpu决定 什么时候执行

        Dog dog = new Dog();
        Thread thread = new Thread(dog); //静态代理模式
        thread.start();


        int times = 0 ;
        while (true){
            System.out.println("main-mao" + "线程" + Thread.currentThread().getName());//main 线程
            times ++ ;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times > 80){
                break;
            }
        }


        // main 线程 跟 Thread-0 线程 会同时进行 不会互相阻塞  是交替执行


    }
}

// 当一个类继承了Thread 该类就可以当作线程使用
class Cat extends Thread{

    int times;

    @Override
    public void run() {  // 重写run 写自己的逻辑
        //super.run();  // 其实是执行 Runnable的run方法
        while (true){
            System.out.println("thread-mao" + "线程" + Thread.currentThread().getName() );
            times ++ ;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times > 80){
                break;
            }
        }

    }
}

//单继承机制 如果已经继承了类 可以通过实现接口 实现线程
class Dog implements Runnable{

    int times;

    @Override
    public void run() {
        while (true){
            System.out.println("thread-dog" + "线程" + Thread.currentThread().getName());
            times ++ ;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (times > 80){
            break;
        }
    }
    }
}