package com.thread;

import java.sql.SQLOutput;

public class Test05 {
    public static void main(String[] args) throws InterruptedException {
        //yield 线程让出cpu 让其他线程执行 但是 礼让时间不确定 也不一定成功
        // 线程的插队 join 线程一旦插队成功 则一定先执行完该线程 但是会阻塞主线程

        System.out.println("qwewq");
        Oo oo = new Oo();
//        oo.start();

        Thread thread = new Thread(new Pp());
        thread.start();

        System.out.println("qeq");
        int a = 0;
        while (true){
            a++;
            System.out.println(a);
            Thread.sleep(1000);
            if (a == 10){
                thread.join(); //线程的插队 join 线程一旦插队成功 则一定先执行完该线程 但是会阻塞主线程
            }
            if (a > 20){
                break;
            }
        }
    }
}

class Oo extends Thread{
    int a;
    @Override
    public void run() {
        while (true){
            System.out.println("qqq");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            a++;
            if (a > 15){
                break;
            }
        }
    }
}

class Pp implements Runnable{
    int a;

    @Override
    public void run() {
        while (true){
            System.out.println("qqq");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            a++;
            if (a > 15){
                break;
            }
        }
    }
}