package com.thread;

/**
 * 三个窗口模拟多线程
 * */

public class Test02 {
    public static void main(String[] args) {

//        Ticket ticket0 = new Ticket();
//        Ticket ticket1 = new Ticket();
//        Ticket ticket2 = new Ticket();
//
//        ticket0.start();
//        ticket1.start();
//        ticket2.start();

        Ticket2 Ticket2 = new Ticket2();

        Thread thread0 = new Thread(Ticket2);
        Thread thread1 = new Thread(Ticket2);
        Thread thread2 = new Thread(Ticket2);

        thread0.start();
        thread1.start();
        thread2.start();



    }
}

class Ticket extends Thread{

    private static int counts = 100; // static 修饰 被所有类共享

    @Override
    public void run() {
        while (true){
            if (counts <= 0){
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" + "剩余" + (--counts));
        }
    }
}

class Ticket1 implements Runnable{

    private  int counts = 100; // static 修饰 被所有类共享

    @Override
    public void run() {
        while (true){
            if (counts <= 0){
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" + "剩余" + (--counts));
        }
    }
}


// 使用 synchronized 同步方法
class Ticket2 implements Runnable{

    private  int counts = 100; // static 修饰 被所有类共享

    @Override
    public synchronized void run() {
        while (true){
            if (counts <= 0){
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" + "剩余" + (--counts));
        }
    }
}
