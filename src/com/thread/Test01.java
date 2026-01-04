package com.thread;

public class Test01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();


        Thread thread = new Thread(new Dog());
        thread.start();

        //匿名内部类
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //通过 Runnable 可以实现多个线程使用同一个资源  多个线程使用同一个run方法

        int times = 0;
        while (true){
            System.out.println("miao" + "线程" + Thread.currentThread().getName());
            times ++ ;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (times > 10){
                break;
            }

        }


    }
}

class Cat extends Thread{
    int times ;
    @Override
    public void run()  {
        while (true){
            System.out.println("miao" + "线程" + Thread.currentThread().getName());
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

class Dog implements Runnable{
    @Override
    public void run() {
        System.out.println("dog" + "线程" + Thread.currentThread().getName());
    }
}
